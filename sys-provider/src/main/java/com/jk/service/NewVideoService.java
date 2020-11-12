package com.jk.service;

import com.jk.entity.NewVideo;
import com.jk.pojo.PageResult;

public interface NewVideoService {
    PageResult selectHot(Integer currPage, Integer pageSize, NewVideo hot);

    void addHot(NewVideo hot);

    void delHot(String id);

    NewVideo huiHot(Integer id);
}
