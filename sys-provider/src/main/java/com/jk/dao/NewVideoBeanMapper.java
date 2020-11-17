package com.jk.dao;

import com.jk.entity.NewVideoBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewVideoBeanMapper {
    int deleteByPrimaryKey(Integer newHotId);

    void insert(NewVideoBean newVideoBean);

    int insertSelective(NewVideoBean record);

    NewVideoBean selectByPrimaryKey(Integer newHotId);

    int updateByPrimaryKeySelective(NewVideoBean record);

    int updateByPrimaryKey(NewVideoBean record);

    void inserNewVideo(NewVideoBean newVideoBean);
}