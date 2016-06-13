package com.lssm.service;

import com.lssm.model.LemonCustomer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
@Service
public interface LemonCustomerService {
    List<LemonCustomer> findCustomers(HashMap<String, Object> hashMap) throws Exception;

    int add(LemonCustomer record);

    LemonCustomer findOne(int id);

    int update(LemonCustomer record);
}
