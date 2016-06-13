package com.lssm.controller;

import com.lssm.model.LemonCustomer;
import com.lssm.service.LemonCustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView)
    {
        return  modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(ModelAndView modelAndView, HttpServletRequest request)
    {

        String customerName = request.getParameter("customerName");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        int effective = Integer.parseInt(request.getParameter("effective"));

        if (!customerName.isEmpty() && !mobile.isEmpty() && !password.isEmpty()) {
            LemonCustomer record = new LemonCustomer();

            record.setCustomerName(customerName);
            record.setMobile(mobile);
            record.setPassword(password);
            record.setEffective(effective);

            modelAndView.addObject("customer", record);

            int id = lemonCustomerService.add(record);

            if (id <= 0) modelAndView.addObject("error", "Added Failed");
        }

        return "redirect: /customer/index";
    }
}
