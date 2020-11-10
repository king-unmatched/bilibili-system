package com.jk.dao;

import com.jk.entity.ComicVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ComicVideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ComicVideo record);

    int insertSelective(ComicVideo record);

    ComicVideo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ComicVideo record);

    int updateByPrimaryKey(ComicVideo record);

    Long selectcount(@Param("comc") ComicVideo comi);

    List<ComicVideo> listCo(@Param("currPage")Integer currPage, @Param("pageSize")Integer pageSize, @Param("comc")ComicVideo comi);

    void delC(@Param("id") String id);
}