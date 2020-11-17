package com.jk.service;

import com.jk.entity.JxChoiceness;
import com.jk.pojo.PageResult;

public interface JxChoicenessService {
    PageResult selectJx(Integer currPage, Integer pageSize, JxChoiceness jx);

    void addJx(JxChoiceness jx);

    void delJx(String id);

    JxChoiceness huiJx(Integer id);
}
