package com.jk.dao;

import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBean record);

    int insertSelective(UserBean record);

    UserBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBean record);

    int updateByPrimaryKey(UserBean record);

    UserBean seluser(@Param("userCode") String userCode);

    List<TreeBean> seltreefind(@Param("pid") int pid,@Param("userId") Integer userId);

    List<String> selprincipList(Integer id);
}