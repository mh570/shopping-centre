package com.fengling.common.to;

import lombok.Data;

import java.math.BigDecimal;


public class SpuBoundTo {

    private Long spuId;

    public SpuBoundTo(Long spuId, BigDecimal buyBounds, BigDecimal growBounds) {
        this.spuId = spuId;
        this.buyBounds = buyBounds;
        this.growBounds = growBounds;
    }

    public SpuBoundTo() {
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public BigDecimal getBuyBounds() {
        return buyBounds;
    }

    public void setBuyBounds(BigDecimal buyBounds) {
        this.buyBounds = buyBounds;
    }

    public BigDecimal getGrowBounds() {
        return growBounds;
    }

    public void setGrowBounds(BigDecimal growBounds) {
        this.growBounds = growBounds;
    }

    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}
