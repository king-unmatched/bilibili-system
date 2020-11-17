package com.jk.service.impl;

import com.jk.dao.JxChoicenessMapper;
import com.jk.entity.JxChoiceness;
import com.jk.pojo.PageResult;
import com.jk.service.JxChoicenessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JxChoicenessImpl implements JxChoicenessService {
    @Autowired
    private JxChoicenessMapper jxChoicenessMapper;

    @Override
    public PageResult selectJx(Integer currPage, Integer pageSize, JxChoiceness jx) {
        Long total = jxChoicenessMapper.selectcount(jx);
        List<JxChoiceness> list = jxChoicenessMapper.selectJx(currPage, pageSize,jx);
        Long totalPage = total%pageSize == 0 ? total/pageSize : (total/pageSize + 1);
        return new PageResult(total, list, currPage, pageSize, totalPage);
    }

    @Override
    public void addJx(JxChoiceness jx) {
        if(jx.getChoicenessId()==null){
            jxChoicenessMapper.insert(jx);
        }else{
           jxChoicenessMapper.updateByPrimaryKeySelective(jx);
        }
    }

    @Override
    public void delJx(String id) {
        jxChoicenessMapper.delJx(id);
    }

    @Override
    public JxChoiceness huiJx(Integer id) {
        return jxChoicenessMapper.selectByPrimaryKey(id);
    }
}
