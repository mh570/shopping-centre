package com.fengling.shopping.elasticsearch.vo;

import java.util.List;

public class SearchParam {

    private String keyword;
    private Long catalog3Id;
    private String sort;
    private Integer hasStock;
    private String skuPrice;
    private List<Long> brandId;
    private List<String> attrs;
    private Integer pageNum;
    private String _queryString;


    public SearchParam() {
    }

    public SearchParam(String keyword, Long catalog3Id, String sort, Integer hasStock, String skuPrice, List<Long> brandId, List<String> attrs, Integer pageNum, String _queryString) {
        this.keyword = keyword;
        this.catalog3Id = catalog3Id;
        this.sort = sort;
        this.hasStock = hasStock;
        this.skuPrice = skuPrice;
        this.brandId = brandId;
        this.attrs = attrs;
        this.pageNum = pageNum;
        this._queryString = _queryString;
    }

    public String get_queryString() {
        return _queryString;
    }

    public void set_queryString(String _queryString) {
        this._queryString = _queryString;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Long getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(Long catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getHasStock() {
        return hasStock;
    }

    public void setHasStock(Integer hasStock) {
        this.hasStock = hasStock;
    }

    public String getSkuPrice() {
        return skuPrice;
    }

    public void setSkuPrice(String skuPrice) {
        this.skuPrice = skuPrice;
    }

    public List<Long> getBrandId() {
        return brandId;
    }

    public void setBrandId(List<Long> brandId) {
        this.brandId = brandId;
    }

    public List<String> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<String> attrs) {
        this.attrs = attrs;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
}
