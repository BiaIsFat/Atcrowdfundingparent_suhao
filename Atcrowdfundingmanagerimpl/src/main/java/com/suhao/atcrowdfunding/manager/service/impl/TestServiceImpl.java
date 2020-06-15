package com.suhao.atcrowdfunding.manager.service.impl;

import com.suhao.atcrowdfunding.manager.dao.TestDao;
import com.suhao.atcrowdfunding.manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author suhao
 * @create_date 2020-05-13 14:15
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;

    public void insert() {
        Map map=new HashMap();
        map.put("name","zhangsan");
        testDao.insert(map);
    }
}
