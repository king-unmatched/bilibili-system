package com.jk.service.impl;

import com.jk.dao.DysyVideoMapper;
import com.jk.entity.DysyVideo;
import com.jk.pojo.PageResult;
import com.jk.service.DyVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DyVideoServiceImpl implements DyVideoService {
    @Autowired
    private DysyVideoMapper dysyVideoMapper;

    @Override
    public PageResult listDy(Integer currPage, Integer pageSize, DysyVideo dys) {
        Long total = dysyVideoMapper.selectcount(dys);
        List<DysyVideo> list = dysyVideoMapper.listDy(currPage, pageSize,dys);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void addDys(DysyVideo dys) {
        if(dys.getVideoId()==null){
            dysyVideoMapper.insert(dys);
        }else{
            dysyVideoMapper.updateByPrimaryKeySelective(dys);
        }
    }

    @Override
    public void deleteD(String id) {
        dysyVideoMapper.deleteD(id);
    }

    @Override
    public DysyVideo huixian(Integer id) {
      return  dysyVideoMapper.selectByPrimaryKey(id);
    }
}
