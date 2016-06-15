package com.lssm.serviceImpl;


import com.lssm.model.LemonCustomer;
import com.lssm.mapper.LemonCustomerMapper;
import com.lssm.service.LemonCustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
@Service
public class LemonCustomerServiceImpl implements LemonCustomerService {

    @Resource
    LemonCustomerMapper lemonCustomerMapper;

    @Override
    public List<LemonCustomer> findCustomers(HashMap<String, Object> hashMap) throws Exception {
        List<LemonCustomer> customers = lemonCustomerMapper.selectCustomers(hashMap);
        return customers;
    }

    @Override
    public int add(LemonCustomer record) {

        int id = lemonCustomerMapper.insertSelective(record);
        return id;
    }

    @Override
    public LemonCustomer findOne(int id) {
        LemonCustomer customer =  lemonCustomerMapper.selectByPrimaryKey(id);
        return customer;
    }

    public int update(LemonCustomer record)
    {
        int result = lemonCustomerMapper.updateByPrimaryKeySelective(record);
        return  result;
    }

    @Override
    public int count(HashMap<String, Object> hashMap) {
        int c = lemonCustomerMapper.count(hashMap);
        return c;
    }


}
