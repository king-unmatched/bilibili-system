package com.jk.service.impl;

import com.jk.dao.NewVideoMapper;
import com.jk.entity.NewVideo;
import com.jk.pojo.PageResult;
import com.jk.dao.NewVideoBeanMapper;
import com.jk.entity.NewVideoBean;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewVideoServiceImpl implements NewVideoService {
    @Autowired
    private NewVideoBeanMapper newVideoBeanMapper;
    @Autowired
    private NewVideoMapper newVideoMapper;


    @Override
    public PageResult selectHot(Integer currPage, Integer pageSize, NewVideo hot) {
        Long total = newVideoMapper.selectcount(hot);
        List<NewVideo> list = newVideoMapper.selectHot(currPage, pageSize,hot);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void addHot(NewVideo hot) {
         if(hot.getNewHotId()==null){
             newVideoMapper.addHot(hot);
         }else{
             newVideoMapper.update(hot);
         }
    }

    @Override
    public void delHot(String id) {
        newVideoMapper.delHot(id);
    }

    @Override
    public NewVideo huiHot(Integer id) {
        return newVideoMapper.huiHot(id);
    }

    @Override
    public void inserNewVideo(NewVideoBean newVideoBean) {
        newVideoBeanMapper.inserNewVideo(newVideoBean);
    }
}
