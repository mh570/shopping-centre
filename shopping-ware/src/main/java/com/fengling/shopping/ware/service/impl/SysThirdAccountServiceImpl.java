package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.SysThirdAccountDao;
import com.fengling.shopping.ware.entity.SysThirdAccountEntity;
import com.fengling.shopping.ware.service.SysThirdAccountService;


@Service("sysThirdAccountService")
public class SysThirdAccountServiceImpl extends ServiceImpl<SysThirdAccountDao, SysThirdAccountEntity> implements SysThirdAccountService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SysThirdAccountEntity> page = this.page(
                new Query<SysThirdAccountEntity>().getPage(params),
                new QueryWrapper<SysThirdAccountEntity>()
        );

        return new PageUtils(page);
    }

}