package com.jk.service.impl;

import com.jk.dao.NewVideoBeanMapper;
import com.jk.entity.NewVideoBean;
import com.jk.service.NewVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewVideoServiceImpl implements NewVideoService {

    @Autowired
    private NewVideoBeanMapper newVideoBeanMapper;

    @Override
    public void inserNewVideo(NewVideoBean newVideoBean) {
        newVideoBeanMapper.inserNewVideo(newVideoBean);
    }
}
