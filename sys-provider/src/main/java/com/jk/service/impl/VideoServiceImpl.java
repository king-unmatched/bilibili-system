package com.jk.service.impl;

import com.jk.dao.VideoBeanMapper;
import com.jk.entity.VideoBean;
import com.jk.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoBeanMapper videoBeanMapper;

    @Override
    public List<VideoBean> selVideoBean() {
        return videoBeanMapper.selVideoBean();
    }
}
