package com.lssm.service;

import com.lssm.model.LemonCustomer;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
@Service
public interface LemonCustomerService {
    List<LemonCustomer> findCustomers() throws Exception;
}
