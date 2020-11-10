package com.jk.service;

import com.jk.entity.ComicVideo;
import com.jk.pojo.PageResult;

public interface ComicVideoService {
    PageResult listCo(Integer currPage, Integer pageSize, ComicVideo comi);

    void addC(ComicVideo comic);

    void delC(String id);

    ComicVideo huiC(Integer id);
}
