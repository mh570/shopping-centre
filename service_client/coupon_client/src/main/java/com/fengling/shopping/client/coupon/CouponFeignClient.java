package com.fengling.shopping.client.coupon;

import com.fengling.common.to.SkuReductionTo;
import com.fengling.common.to.SpuBoundTo;
import com.fengling.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "shopping-coupon")
public interface CouponFeignClient {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();

    /**
     *
     * @PostMapping("/save")
     * public R save(@RequestBody SpuBoundsEntity spuBounds){
     */
    @PostMapping("/coupon/spubounds/save")
    public R saveSpuBouds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    public R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
