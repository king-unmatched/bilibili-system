package com.jk.service.impl;

import com.jk.dao.ComicVideoMapper;
import com.jk.entity.ComicVideo;
import com.jk.pojo.PageResult;
import com.jk.service.ComicVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComicVideoServiceImpl implements ComicVideoService {
    @Autowired
    private ComicVideoMapper comicVideoMapper;

    @Override
    public PageResult listCo(Integer currPage, Integer pageSize, ComicVideo comi) {
        Long total = comicVideoMapper.selectcount(comi);
        List<ComicVideo> list = comicVideoMapper.listCo(currPage, pageSize,comi);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void addC(ComicVideo comic) {
        if(comic.getId()==null){
            comic.setToUpdate(new Date());
            comicVideoMapper.insert(comic);
        }else{
            comic.setToUpdate(new Date());
            comicVideoMapper.updateByPrimaryKeySelective(comic);
        }
    }

    @Override
    public void delC(String id) {
        comicVideoMapper.delC(id);
    }

    @Override
    public ComicVideo huiC(Integer id) {
        return comicVideoMapper.selectByPrimaryKey(id);
    }
}
