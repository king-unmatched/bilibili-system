package com.jk.dao;

import com.jk.entity.VideoBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoBeanMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(VideoBean record);

    int insertSelective(VideoBean record);

    VideoBean selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(VideoBean record);

    int updateByPrimaryKey(VideoBean record);

    List<VideoBean> selVideoBean();
}