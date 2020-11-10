package com.jk.service;

import com.jk.entity.DysyVideo;
import com.jk.pojo.PageResult;

public interface DyVideoService {
    PageResult listDy(Integer currPage, Integer pageSize, DysyVideo dys);

    void addDys(DysyVideo dys);

    void deleteD(String id);

    DysyVideo huixian(Integer id);
}
