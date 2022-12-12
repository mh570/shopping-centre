package com.fengling.shopping.ware.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengling.common.utils.PageUtils;
import com.fengling.common.utils.Query;

import com.fengling.shopping.ware.dao.JeecgOrderTicketDao;
import com.fengling.shopping.ware.entity.JeecgOrderTicketEntity;
import com.fengling.shopping.ware.service.JeecgOrderTicketService;


@Service("jeecgOrderTicketService")
public class JeecgOrderTicketServiceImpl extends ServiceImpl<JeecgOrderTicketDao, JeecgOrderTicketEntity> implements JeecgOrderTicketService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JeecgOrderTicketEntity> page = this.page(
                new Query<JeecgOrderTicketEntity>().getPage(params),
                new QueryWrapper<JeecgOrderTicketEntity>()
        );

        return new PageUtils(page);
    }

}