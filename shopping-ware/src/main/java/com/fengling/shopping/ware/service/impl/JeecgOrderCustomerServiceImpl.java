package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JeecgOrderCustomerDao;
import com.fengling.shopping.ware.entity.JeecgOrderCustomerEntity;
import com.fengling.shopping.ware.service.JeecgOrderCustomerService;


@Service("jeecgOrderCustomerService")
public class JeecgOrderCustomerServiceImpl extends ServiceImpl<JeecgOrderCustomerDao, JeecgOrderCustomerEntity> implements JeecgOrderCustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JeecgOrderCustomerEntity> page = this.page(
                new Query<JeecgOrderCustomerEntity>().getPage(params),
                new QueryWrapper<JeecgOrderCustomerEntity>()
        );

        return new PageUtils(page);
    }

}