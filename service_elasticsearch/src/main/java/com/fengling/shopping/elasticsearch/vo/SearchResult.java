package com.fengling.shopping.elasticsearch.vo;

import com.fengling.common.to.es.SkuEsModel;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private List<SkuEsModel> products;
    private Long total;
    private Integer totalPages;
    private Integer pageNum;
    private List<BrandVo> brandVos;
    private List<AttrVo> attrVos;
    private List<CatalogVo> catalogVos;
    private List<Integer> pageNavs;

    private List<NavVo> navs = new ArrayList<>();
    private List<Long> attrIds = new ArrayList<>();

    public SearchResult(List<SkuEsModel> products, Long total, Integer totalPages, Integer pageNum, List<BrandVo> brandVos, List<AttrVo> attrVos, List<CatalogVo> catalogVos, List<Integer> pageNavs, List<NavVo> navs) {
        this.products = products;
        this.total = total;
        this.totalPages = totalPages;
        this.pageNum = pageNum;
        this.brandVos = brandVos;
        this.attrVos = attrVos;
        this.catalogVos = catalogVos;
        this.pageNavs = pageNavs;
        this.navs = navs;
    }

    public List<NavVo> getNavs() {
        return navs;
    }

    public void setNavs(List<NavVo> navs) {
        this.navs = navs;
    }

    public SearchResult() {
    }

    public List<Integer> getPageNavs() {
        return pageNavs;
    }

    public void setPageNavs(List<Integer> pageNavs) {
        this.pageNavs = pageNavs;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public List<CatalogVo> getCatalogVos() {
        return catalogVos;
    }

    public void setCatalogVos(List<CatalogVo> catalogVos) {
        this.catalogVos = catalogVos;
    }

    public List<AttrVo> getAttrVos() {
        return attrVos;
    }

    public void setAttrVos(List<AttrVo> attrVos) {
        this.attrVos = attrVos;
    }

    public List<SkuEsModel> getProducts() {
        return products;
    }

    public void setProducts(List<SkuEsModel> products) {
        this.products = products;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<BrandVo> getBrandVos() {
        return brandVos;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<Long> getAttrIds() {
        return attrIds;
    }

    public void setAttrIds(List<Long> attrIds) {
        this.attrIds = attrIds;
    }


    public static class NavVo {
        private String navName;
        private String navValue;
        private String link;

        public NavVo() {
        }

        public NavVo(String navName, String navValue, String link) {
            this.navName = navName;
            this.navValue = navValue;
            this.link = link;
        }

        public String getNavName() {
            return navName;
        }

        public void setNavName(String navName) {
            this.navName = navName;
        }

        public String getNavValue() {
            return navValue;
        }

        public void setNavValue(String navValue) {
            this.navValue = navValue;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    public void setBrandVos(List<BrandVo> brandVos) {
        this.brandVos = brandVos;
    }

    public static class BrandVo {
        private Long brandId;
        private String brandName;
        private String brandImg;

        public BrandVo() {
        }

        public BrandVo(Long brandId, String brandName, String brandImg) {
            this.brandId = brandId;
            this.brandName = brandName;
            this.brandImg = brandImg;
        }

        public Long getBrandId() {
            return brandId;
        }

        public void setBrandId(Long brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandImg() {
            return brandImg;
        }

        public void setBrandImg(String brandImg) {
            this.brandImg = brandImg;
        }
    }

    public static class AttrVo {
        private Long attrId;
        private String attrName;
        private List<String> attrValue;

        public Long getAttrId() {
            return attrId;
        }

        public void setAttrId(Long attrId) {
            this.attrId = attrId;
        }

        public String getAttrName() {
            return attrName;
        }

        public void setAttrName(String attrName) {
            this.attrName = attrName;
        }

        public List<String> getAttrValue() {
            return attrValue;
        }

        public void setAttrValue(List<String> attrValue) {
            this.attrValue = attrValue;
        }
    }

    public static class CatalogVo {
        private Long catalogId;
        private String catalogName;

        public Long getCatalogId() {
            return catalogId;
        }

        public void setCatalogId(Long catalogId) {
            this.catalogId = catalogId;
        }

        public String getCatalogName() {
            return catalogName;
        }

        public void setCatalogName(String catalogName) {
            this.catalogName = catalogName;
        }
    }
}
