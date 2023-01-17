package com.fengling.shopping.ware.service.impl;

import com.fengling.common.constant.WareConstant;
import com.fengling.shopping.ware.entity.PurchaseDetailEntity;
import com.fengling.shopping.ware.service.PurchaseDetailService;
import com.fengling.shopping.ware.service.WareSkuService;
import com.fengling.shopping.ware.vo.MergeVo;
import com.fengling.shopping.ware.vo.PurchaseDoneVo;
import com.fengling.shopping.ware.vo.PurchaseItemDoneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.PurchaseDao;
import com.fengling.shopping.ware.entity.PurchaseEntity;
import com.fengling.shopping.ware.service.PurchaseService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("purchaseService")
public class PurchaseServiceImpl extends ServiceImpl<PurchaseDao, PurchaseEntity> implements PurchaseService {

    @Autowired
    private PurchaseDetailService detailService;
    @Autowired
    private WareSkuService wareSkuService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<PurchaseEntity> queryWrapper = new QueryWrapper<>();
//        String key = (String) params.get("key");
//        if (StringUtils.hasText(key)) {
//            queryWrapper.and(item->{
//                item.eq("purchase_id", key).or().eq("sku_id", key);
//            });
//        }
//        String status = (String) params.get("status");
//        if (StringUtils.hasText(status)) {
//            queryWrapper.eq("status", status);
//        }
//        String wareId = (String) params.get("wareId");
//        if (StringUtils.hasText(wareId)) {
//            queryWrapper.eq("ware_id", wareId);
//        }

        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageUnreceiveList(Map<String, Object> params) {
        QueryWrapper<PurchaseEntity> queryWrapper = new QueryWrapper<>();
        IPage<PurchaseEntity> page = this.page(
                new Query<PurchaseEntity>().getPage(params),
                queryWrapper.eq("status", 0).or().eq("status", 1)
        );

        return new PageUtils(page);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void mergePurchase(MergeVo mergeVo) {
        Long purchaseId = mergeVo.getPurchaseId();
        if (purchaseId == null) {
            PurchaseEntity purchaseEntity = new PurchaseEntity();
            purchaseEntity.setStatus(WareConstant.PurchaseStatusEnum.CREATED.getCode());
            purchaseEntity.setCreateTime(new Date());
            purchaseEntity.setUpdateTime(new Date());
            this.baseMapper.insert(purchaseEntity);
            purchaseId = purchaseEntity.getId();
        }

        List<Long> items = mergeVo.getItems();
        Long finalPurchaseId = purchaseId;
        List<PurchaseDetailEntity> collect = items.stream().map(item -> {
            PurchaseDetailEntity purchaseDetailEntity = new PurchaseDetailEntity();
            purchaseDetailEntity.setId(item);
            purchaseDetailEntity.setPurchaseId(finalPurchaseId);
            purchaseDetailEntity.setStatus(WareConstant.PurchaseDetailStatusEnum.ASSIGNED.getCode());
            return purchaseDetailEntity;
        }).collect(Collectors.toList());
        detailService.updateBatchById(collect);

        PurchaseEntity entity = new PurchaseEntity();
        entity.setUpdateTime(new Date());
        entity.setId(purchaseId);
        this.baseMapper.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void received(List<Long> id) {
        List<PurchaseEntity> collect = id.stream().map(item -> {
            PurchaseEntity entity = this.baseMapper.selectById(item);
            return entity;
        }).filter(item -> {
            if (item.getStatus() == WareConstant.PurchaseStatusEnum.CREATED.getCode() ||
                    item.getStatus() == WareConstant.PurchaseStatusEnum.ASSIGNED.getCode()) {
                return true;
            }
            return false;
        }).map(item -> {
            item.setStatus(WareConstant.PurchaseStatusEnum.RECEIVE.getCode());
            item.setUpdateTime(new Date());
            return item;
        }).collect(Collectors.toList());
//        null空
        this.updateBatchById(collect);

        collect.forEach(item -> {
            List<PurchaseDetailEntity> entityList = detailService.listDetaiByPurchaseId(item.getId());
//            entityList null，业务逻辑bug，正常问题，没有处理自定义异常设置
            List<PurchaseDetailEntity> collect1 = entityList.stream().map(list -> {
                PurchaseDetailEntity entity = new PurchaseDetailEntity();
                entity.setId(list.getId());
                entity.setStatus(WareConstant.PurchaseDetailStatusEnum.BUYING.getCode());
                return entity;
            }).collect(Collectors.toList());
            detailService.updateBatchById(collect1);
        });
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void done(PurchaseDoneVo doneVo) {
        Long id = doneVo.getId();
        boolean flag = true;

        List<PurchaseDetailEntity> itemDoneVoList = new ArrayList<>();
        List<PurchaseItemDoneVo> items = doneVo.getItems();
        for (PurchaseItemDoneVo item : items) {
            PurchaseDetailEntity entity = new PurchaseDetailEntity();
            if (item.getStatus() == WareConstant.PurchaseDetailStatusEnum.HASERROR.getCode()) {
                flag = false;
                entity.setStatus(item.getStatus());
            } else {
                entity.setStatus(WareConstant.PurchaseDetailStatusEnum.FINISH.getCode());
                PurchaseDetailEntity byId = detailService.getById(item.getItemId());

                wareSkuService.addStock(byId.getSkuId(), byId.getWareId(), byId.getSkuNum());
            }
            entity.setId(item.getItemId());
            itemDoneVoList.add(entity);
        }
        detailService.updateBatchById(itemDoneVoList);


        PurchaseEntity purchase = new PurchaseEntity();
        purchase.setId(id);
        purchase.setStatus(flag ? WareConstant.PurchaseDetailStatusEnum.FINISH.getCode() : WareConstant.PurchaseDetailStatusEnum.HASERROR.getCode());
        purchase.setUpdateTime(new Date());
        this.baseMapper.updateById(purchase);

    }
}