package com.fengling.shopping.elasticsearch.vo;

import com.fengling.common.to.es.SkuEsModel;

import java.util.List;

public class SearchResult {
    private List<SkuEsModel> products;
    private Long total;
    private Integer totalPages;

    private List<BrandVo> brandVos;
    private List<AttrVo> attrVos;
    private List<CatalogVo> catalogVos;

    public SearchResult() {
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
