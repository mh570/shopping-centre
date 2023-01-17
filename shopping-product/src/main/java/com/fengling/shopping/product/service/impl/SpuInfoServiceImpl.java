package com.fengling.shopping.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fengling.common.constant.ProductConstant;
import com.fengling.common.to.MemberPrice;
import com.fengling.common.to.SkuHasStockVo;
import com.fengling.common.to.SkuReductionTo;
import com.fengling.common.to.SpuBoundTo;
import com.fengling.common.to.es.SkuEsModel;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;
import com.fengling.common.utils.R;
import com.fengling.shopping.client.coupon.CouponFeignClient;
import com.fengling.shopping.client.elastic.ElasticFeignClient;
import com.fengling.shopping.client.ware.WareFeignClient;
import com.fengling.shopping.product.dao.SpuInfoDao;
import com.fengling.shopping.product.entity.*;
import com.fengling.shopping.product.service.*;
import com.fengling.shopping.product.vo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Autowired
    private SpuInfoDescService spuInfoDescService;
    @Autowired
    private SpuImagesService imagesService;
    @Autowired
    private AttrService attrService;
    @Autowired
    private ProductAttrValueService attrValueService;
    @Autowired
    private SkuInfoService infoService;
    @Autowired
    private SkuImagesService skuImagesService;
    @Autowired
    private SkuSaleAttrValueService saleAttrValueService;
    @Autowired
    private CouponFeignClient couponFeignClient;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private WareFeignClient wareFeignClient;
    @Autowired
    private ElasticFeignClient elasticFeignClient;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveSpuInfo(SpuSaveVo saveVo) {
        SpuInfoEntity spuInfoEntity = new SpuInfoEntity();
        BeanUtils.copyProperties(saveVo, spuInfoEntity);
        spuInfoEntity.setUpdateTime(new Date());
        spuInfoEntity.setCreateTime(new Date());
        this.saveBaseSpuInfo(spuInfoEntity);

        List<String> decript = saveVo.getDecript();
        SpuInfoDescEntity descEntity = new SpuInfoDescEntity();
        descEntity.setSpuId(spuInfoEntity.getId());
        descEntity.setDecript(String.join(",", decript));
        spuInfoDescService.saveSpuInfoDesc(descEntity);

        List<String> images = saveVo.getImages();
        imagesService.saveImages(spuInfoEntity.getId(), images);


        List<BaseAttrs> baseAttrs = saveVo.getBaseAttrs();
        List<ProductAttrValueEntity> collect = baseAttrs.stream().map(item -> {
            ProductAttrValueEntity valueEntity = new ProductAttrValueEntity();
            valueEntity.setAttrId(item.getAttrId());
            AttrEntity byId = attrService.getById(item.getAttrId());
            valueEntity.setAttrName(byId.getAttrName());
            valueEntity.setAttrValue(item.getAttrValues());
            valueEntity.setQuickShow(item.getShowDesc());
            valueEntity.setSpuId(spuInfoEntity.getId());
            return valueEntity;
        }).collect(Collectors.toList());
        attrValueService.saveProductAttr(collect);

        Bounds bounds = saveVo.getBounds();
        SpuBoundTo spuBoundTo = new SpuBoundTo();
        BeanUtils.copyProperties(bounds, spuBoundTo);
        spuBoundTo.setSpuId(spuInfoEntity.getId());
        R r = couponFeignClient.saveSpuBouds(spuBoundTo);
        if (r.getCode() != 0) {
            log.error("错误95处SpuInfoServiceImpl");
        }


        List<Skus> skus = saveVo.getSkus();
        if (skus != null && skus.size() > 0) {
            skus.stream().forEach(item -> {
                String defaultImg = "";

                for (Images img : item.getImages()) {
                    if (img.getDefaultImg() == 1) {
                        defaultImg = img.getImgUrl();
                    }
                }

                System.out.println("这是"+defaultImg);
                SkuInfoEntity skuInfoEntity = new SkuInfoEntity();
                BeanUtils.copyProperties(item, skuInfoEntity);
                skuInfoEntity.setBrandId(spuInfoEntity.getBrandId());
                skuInfoEntity.setCatalogId(spuInfoEntity.getCatalogId());
                skuInfoEntity.setSaleCount(0L);
                skuInfoEntity.setSpuId(spuInfoEntity.getId());
                skuInfoEntity.setSkuDefaultImg(defaultImg);
                infoService.saveSkuInfo(skuInfoEntity);

                Long skuId = skuInfoEntity.getSkuId();
                List<SkuImagesEntity> skuImagesEntityList = item.getImages().stream().map(img -> {
                    SkuImagesEntity skuImagesEntity = new SkuImagesEntity();
                    skuImagesEntity.setSkuId(skuId);
                    skuImagesEntity.setImgUrl(img.getImgUrl());
                    skuImagesEntity.setDefaultImg(img.getDefaultImg());
                    return skuImagesEntity;
                }).filter(url -> StringUtils.hasText(url.getImgUrl())).collect(Collectors.toList());
                skuImagesService.saveBatch(skuImagesEntityList);

                List<Attr> attr = item.getAttr();
                List<SkuSaleAttrValueEntity> attrValueEntityList = attr.stream().map(a -> {
                    SkuSaleAttrValueEntity skuSaleAttrValueEntity = new SkuSaleAttrValueEntity();
                    BeanUtils.copyProperties(a, skuSaleAttrValueEntity);
                    skuSaleAttrValueEntity.setSkuId(skuId);
                    return skuSaleAttrValueEntity;
                }).collect(Collectors.toList());
                saleAttrValueService.saveBatch(attrValueEntityList);

                SkuReductionTo skuReductionTo = new SkuReductionTo();
                BeanUtils.copyProperties(item, skuReductionTo);
                List<MemberPrice> memberPrice = new ArrayList<>();
                List<com.fengling.shopping.product.vo.MemberPrice> memberPrice1 = item.getMemberPrice();
                for (com.fengling.shopping.product.vo.MemberPrice member :
                        memberPrice1) {
                    MemberPrice memberPrice2 = new MemberPrice();
                    memberPrice2.setId(member.getId());
                    memberPrice2.setName(member.getName());
                    memberPrice.add(memberPrice2);
                }

                skuReductionTo.setMemberPrice(memberPrice);

                skuReductionTo.setSkuId(skuId);
                if (skuReductionTo.getFullCount() >= 0 || skuReductionTo.getFullPrice().compareTo(new BigDecimal("0")) == 1) {
                    R r1 = couponFeignClient.saveSkuReduction(skuReductionTo);
                    if (r1.getCode() != 0) {
                        log.error("错误144处SpuInfoServiceImpl");
                    }
                }
            });
        }
    }


    @Override
    public void saveBaseSpuInfo(SpuInfoEntity spuInfoEntity) {
        this.baseMapper.insert(spuInfoEntity);
    }

    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        QueryWrapper<SpuInfoEntity> queryWrapper = new QueryWrapper<>();
        String key = (String) params.get("key");
        if (StringUtils.hasText(key)) {
            queryWrapper.and(item -> item.eq("id", key).or().like("spu_name", key));
        }
        String status = (String) params.get("status");
        if (StringUtils.hasText(status)) {
            queryWrapper.eq("publish_status", status);
        }
        String brandId = (String) params.get("brandId");
        if (StringUtils.hasText(brandId) && !"0".equalsIgnoreCase(brandId)) {
            queryWrapper.eq("brand_id", brandId);
        }
        String catelogId = (String) params.get("catelogId");
        if (StringUtils.hasText(catelogId) && !"0".equalsIgnoreCase(catelogId)) {
            queryWrapper.eq("catalog_id", catelogId);
        }

        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }



    @Override
    public void up(Long spuId) {


        List<SkuInfoEntity> skuInfoEntityList = infoService.getSkuBySpuId(spuId);

        List<ProductAttrValueEntity> attrList = attrValueService.baseAttrList(spuId);

        List<Long> collect = attrList.stream().map(item -> item.getAttrId()).collect(Collectors.toList());

        List<Long> searchId;

//        if (collect != null && collect.size() > 0) {
//            System.out.println(collect + "啥玩意东西??????????????????");
            searchId = attrService.selectSearchAttrs(collect);
//        } else {
//            searchId = null;
//            System.out.println("空的哦");
//        }

        List<SkuEsModel.Attrs> collect1;
//        if (searchId != null && collect.size() > 0) {
            Set<Long> idSet = new HashSet<>(searchId);
            collect1 = attrList.stream().filter(item -> idSet.contains(item.getAttrId()))
                    .map(item -> {
                        SkuEsModel.Attrs attrs = new SkuEsModel.Attrs();
                        BeanUtils.copyProperties(item, attrs);
                        return attrs;
                    }).collect(Collectors.toList());
//        } else {
//            collect1 = null;
//        }


        List<Long> collect2 = skuInfoEntityList.stream().map(SkuInfoEntity::getSkuId).collect(Collectors.toList());

        Map<Long, Boolean> collect3 = null;
        try {
            R skusHasStock = wareFeignClient.getSkusHasStock(collect2);

            List<SkuHasStockVo> data = skusHasStock.getData(new TypeReference<List<SkuHasStockVo>>() {});

            collect3 = data.stream().collect(Collectors.toMap(SkuHasStockVo::getSkuId, SkuHasStockVo::getHasStock));

        } catch (Exception e) {
            e.printStackTrace();
            log.error("仓库错误，远程调用错误");
        }

        List<SkuEsModel> skuEsModelList = new ArrayList<>();
        for (SkuInfoEntity skuInfo :
                skuInfoEntityList) {
            SkuEsModel skuEsModel = new SkuEsModel();
            BeanUtils.copyProperties(skuInfo, skuEsModel);
            skuEsModel.setSkuPrice(skuInfo.getPrice());
            skuEsModel.setSkuImg(skuInfo.getSkuDefaultImg());

            BrandEntity byId = brandService.getById(skuInfo.getBrandId());
            skuEsModel.setBrandImg(byId.getLogo());
            skuEsModel.setBrandName(byId.getName());

            CategoryEntity byId1 = categoryService.getById(skuInfo.getCatalogId());
            skuEsModel.setCatalogName(byId1.getName());

//            skuEsModel.setHasStock(false);

            if (collect3 == null) {
                skuEsModel.setHasStock(true);
            } else {
                skuEsModel.setHasStock(collect3.get(skuInfo.getSkuId()));
                if (skuEsModel.getHasStock() == null) {
                    skuEsModel.setHasStock(true);
                }
            }


            skuEsModel.setHotScore(0L);

            skuEsModel.setAttrs(collect1);

            skuEsModelList.add(skuEsModel);
        }


        System.out.println(JSON.toJSONString(skuEsModelList)+ "检查数据");
        R r = elasticFeignClient.productStatusUp(skuEsModelList);
        if (r.getCode() == 0) {
            this.baseMapper.updateSpuStatus(spuId, ProductConstant.StatusEnum.SPU_UP.getCode(),new Date());
        }else {

        }
//[{
//            "attrs": [],
//            "brandId": 3,
//                    "brandImg": "https://fengling-png.oss-cn-beijing.aliyuncs.com/2022/12/27/ec928b77-767d-4fda-8df2-ad03605960a5_QQ图片20211029001155.jpg",
//                    "brandName": "656",
//                    "catalogId": 165,
//                    "catalogName": "电子书",
//                    "hasStock": true,
//                    "hotScore": 0,
//                    "saleCount": 0,
//                    "skuId": 3,
//                    "skuImg": "",
//                    "skuPrice": 0.0000,
//                    "skuTitle": "33333333333333 aaaa 嗡嗡嗡 阿萨德",
//                    "spuId": 7
//        }]
    }


}