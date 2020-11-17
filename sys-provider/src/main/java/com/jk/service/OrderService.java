package com.jk.service;

import com.jk.entity.Ddorder;
import com.jk.pojo.PageResult;

public interface OrderService {
    PageResult listOr(Integer currPage, Integer pageSize, Ddorder dd);

    void addOr(Ddorder dd);

    void deleteOr(String id);

    Ddorder huixianOr(Integer id);
}
