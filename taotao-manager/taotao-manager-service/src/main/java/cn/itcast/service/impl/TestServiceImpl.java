package cn.itcast.service.impl;

import cn.itcast.mapper.TestMapper;
import cn.itcast.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public String queryDate() {
        return this.testMapper.queryDate();
    }
}
