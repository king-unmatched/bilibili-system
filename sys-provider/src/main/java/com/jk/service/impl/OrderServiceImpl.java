package com.jk.service.impl;

import com.jk.dao.DdorderMapper;
import com.jk.entity.Ddorder;
import com.jk.pojo.PageResult;
import com.jk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private DdorderMapper ddorderMapper;

    @Override
    public PageResult listOr(Integer currPage, Integer pageSize, Ddorder dd) {
        Long total = ddorderMapper.selectcount(dd);
        List<Ddorder> list = ddorderMapper.listOr(currPage, pageSize,dd);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void addOr(Ddorder dd) {
      if(dd.getOrderId()==null){
          dd.setOrderCreatetime(new Date());
          ddorderMapper.addOr(dd);
      }else{
          dd.setOrderCreatetime(new Date());
          ddorderMapper.updateOr(dd);
       }
    }

    @Override
    public void deleteOr(String id) {
        ddorderMapper.deleteOr(id);
    }

    @Override
    public Ddorder huixianOr(Integer id) {
        return ddorderMapper.selectByPrimaryKey(id);
    }
}
