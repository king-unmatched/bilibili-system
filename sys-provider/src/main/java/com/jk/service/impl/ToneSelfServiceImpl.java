package com.jk.service.impl;

import com.jk.dao.ToneSelfBeanMapper;
import com.jk.entity.ToneSelfBean;
import com.jk.service.ToneSelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToneSelfServiceImpl implements ToneSelfService {

    @Autowired
    private ToneSelfBeanMapper toneSelfBeanMapper;




    @Override
    public List<ToneSelfBean> selToneSelfBean() {
        return toneSelfBeanMapper.selToneSelfBean();
    }

    @Override
    public void upstatus(Integer ids) {
        toneSelfBeanMapper.upstatus(ids);
    }
}
