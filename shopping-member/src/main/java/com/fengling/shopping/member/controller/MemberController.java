package com.fengling.shopping.member.controller;

import java.util.Arrays;
import java.util.Map;


import com.fengling.shopping.client.coupon.CouponFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fengling.shopping.member.entity.MemberEntity;
import com.fengling.shopping.member.service.MemberService;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.R;


/**
 * @author mh570
 * @email 2317295126@qq.com
 * @date 2022-12-12 20:41:24
 */
@RestController
@RequestMapping("member/member")
public class MemberController {


    @Autowired
    private MemberService memberService;

    @Autowired
    CouponFeignClient couponFeignClient;

    @RequestMapping("/couponse")
    public R test() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setNickname("测试");
        System.out.println("测试+1");
        R membercoupons = couponFeignClient.membercoupons();

        return R.ok().put("member", memberEntity).put("coupons", membercoupons.get("coupon"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("member:member:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("member:member:info")
    public R info(@PathVariable("id") Long id) {
        MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("member:member:save")
    public R save(@RequestBody MemberEntity member) {
        memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("member:member:update")
    public R update(@RequestBody MemberEntity member) {
        memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("member:member:delete")
    public R delete(@RequestBody Long[] ids) {
        memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
