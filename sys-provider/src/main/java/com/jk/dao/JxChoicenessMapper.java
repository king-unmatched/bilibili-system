package com.jk.dao;

import com.jk.entity.JxChoiceness;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface JxChoicenessMapper {
    int deleteByPrimaryKey(Integer choicenessId);

    int insert(JxChoiceness record);

    int insertSelective(JxChoiceness record);

    JxChoiceness selectByPrimaryKey(Integer choicenessId);

    int updateByPrimaryKeySelective(JxChoiceness record);

    int updateByPrimaryKey(JxChoiceness record);

    Long selectcount(@Param("jx") JxChoiceness jx);

    List<JxChoiceness> selectJx(@Param("currPage") Integer currPage, @Param("pageSize") Integer pageSize, @Param("jx") JxChoiceness jx);

    void delJx(@Param("id") String id);
}