package com.jk.service;

import com.jk.entity.ToneSelfBean;

import java.util.List;

public interface ToneSelfService {


    List<ToneSelfBean> selToneSelfBean();

    void upstatus(Integer ids);
}
