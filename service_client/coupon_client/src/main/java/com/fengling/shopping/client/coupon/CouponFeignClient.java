package com.fengling.shopping.client.coupon;

import com.fengling.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "shopping-coupon")
public interface CouponFeignClient {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();
}
