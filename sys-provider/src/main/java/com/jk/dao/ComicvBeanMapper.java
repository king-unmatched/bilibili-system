package com.jk.dao;

import com.jk.entity.ComicvBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComicvBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComicvBean record);

    int insertSelective(ComicvBean record);

    ComicvBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComicvBean record);

    int updateByPrimaryKey(ComicvBean record);

    List<ComicvBean> sekcomicv();
}