package com.lssm.controller;

import com.lssm.model.LemonCustomer;
import com.lssm.service.LemonCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/6/8.
 */
@Controller
@RequestMapping("/customer")
public class LemonCustomerController {
    @Resource
    LemonCustomerService lemonCustomerService;

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView) throws Exception {
        List<LemonCustomer> customers = lemonCustomerService.findCustomers();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
