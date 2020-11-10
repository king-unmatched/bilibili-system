package com.jk.dao;

import com.jk.entity.DysyVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DysyVideoMapper {
    int deleteByPrimaryKey(Integer videoId);

    int insert(DysyVideo record);

    int insertSelective(DysyVideo record);

    DysyVideo selectByPrimaryKey(Integer videoId);

    int updateByPrimaryKeySelective(DysyVideo record);

    int updateByPrimaryKey(DysyVideo record);

    Long selectcount(@Param("dys") DysyVideo dys);

    List<DysyVideo> listDy(@Param("currPage")Integer currPage, @Param("pageSize")Integer pageSize, @Param("dys")DysyVideo dys);

    void deleteD(@Param("id") String id);
}