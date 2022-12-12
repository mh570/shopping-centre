package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JeecgProjectNatureIncomeDao;
import com.fengling.shopping.ware.entity.JeecgProjectNatureIncomeEntity;
import com.fengling.shopping.ware.service.JeecgProjectNatureIncomeService;


@Service("jeecgProjectNatureIncomeService")
public class JeecgProjectNatureIncomeServiceImpl extends ServiceImpl<JeecgProjectNatureIncomeDao, JeecgProjectNatureIncomeEntity> implements JeecgProjectNatureIncomeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JeecgProjectNatureIncomeEntity> page = this.page(
                new Query<JeecgProjectNatureIncomeEntity>().getPage(params),
                new QueryWrapper<JeecgProjectNatureIncomeEntity>()
        );

        return new PageUtils(page);
    }

}