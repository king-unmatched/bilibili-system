package com.jk.dao;

import com.jk.entity.NewVideo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewVideoMapper {
    int deleteByPrimaryKey(Integer newHotId);

    int insert(NewVideo record);

    int insertSelective(NewVideo record);

    NewVideo selectByPrimaryKey(Integer newHotId);

    int updateByPrimaryKeySelective(NewVideo record);

    int updateByPrimaryKey(NewVideo record);

    Long selectcount(@Param("hot") NewVideo hot);

    List<NewVideo> selectHot(@Param("currPage") Integer currPage, @Param("pageSize")Integer pageSize, @Param("hot")NewVideo hot);

    void delHot(@Param("id") String id);

    NewVideo huiHot(Integer id);

    void addHot(NewVideo hot);

    void update(NewVideo hot);
}