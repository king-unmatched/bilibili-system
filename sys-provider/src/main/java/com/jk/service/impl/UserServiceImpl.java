package com.jk.service.impl;

import com.jk.dao.UserBeanMapper;
import com.jk.entity.TreeBean;
import com.jk.entity.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserBeanMapper userBeanMapper;


    @Override
    public UserBean seluser(String userCode) {
        return userBeanMapper.seluser(userCode);
    }

    @Override
    public List<TreeBean> serTreeBeanList(Integer userId) {
        Integer pid = 1;
        List<TreeBean> treeList = nodeList(pid, userId);
        return treeList;
    }



    private List<TreeBean> nodeList(Integer pid, Integer userId) {
        List<TreeBean> treeList = userBeanMapper.seltreefind(pid, userId);
        for (TreeBean tree :
                treeList) {
            List<TreeBean> nodeList = nodeList(tree.getId(), userId);
            if (nodeList == null || nodeList.size() <= 0) {
                tree.setSelectable(true);
                tree.setLeaf(true);
            } else {
                tree.setSelectable(false);
                tree.setNodes(nodeList);
            }
        }
        return treeList;
    }
    @Override
    public List<String> selprincipList(Integer id) {
        return userBeanMapper.selprincipList(id);
    }
}
