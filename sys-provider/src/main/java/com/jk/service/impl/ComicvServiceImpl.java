package com.jk.service.impl;

import com.jk.dao.ComicvBeanMapper;
import com.jk.entity.ComicvBean;
import com.jk.service.ComicvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComicvServiceImpl implements ComicvService {

    @Autowired
    private ComicvBeanMapper comicvBeanMapper;

    @Override
    public List<ComicvBean> sekcomicv() {
        return comicvBeanMapper.sekcomicv();
    }
}
