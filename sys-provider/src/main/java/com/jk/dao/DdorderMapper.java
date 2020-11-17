package com.jk.dao;

import com.jk.entity.Ddorder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DdorderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(Ddorder record);

    int insertSelective(Ddorder record);

    Ddorder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(Ddorder record);

    int updateByPrimaryKey(Ddorder record);

    Long selectcount(@Param("dd") Ddorder dd);

    List<Ddorder> listOr(@Param("currPage")Integer currPage, @Param("pageSize")Integer pageSize, @Param("dd")Ddorder dd);

    void deleteOr(@Param("id") String id);

    void addOr(Ddorder dd);

    void updateOr(Ddorder dd);
}