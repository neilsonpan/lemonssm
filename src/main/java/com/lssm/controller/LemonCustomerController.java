package com.lssm.controller;

import com.lssm.model.LemonCustomer;
import com.lssm.service.LemonCustomerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();

        String mobile = request.getParameter("mobile");

        hashMap.put("mobile", mobile);
        modelAndView.addObject("mobile", mobile);

        List<LemonCustomer> customers = lemonCustomerService.findCustomers(hashMap);
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView)
    {
        return  modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView modelAndView, HttpServletRequest request)
    {

        LemonCustomer record = this.getRecord(request);

        String msg = this.validate(record);
        modelAndView.addObject("customer", record);

        if (msg != null && msg.length() > 0)
        {
            modelAndView.addObject("error", msg);
            return modelAndView;
        }

        int id = lemonCustomerService.add(record);

        return new ModelAndView("redirect: /customer/index");
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public  ModelAndView update(@Param("id") Integer id, ModelAndView modelAndView)
    {
        LemonCustomer customer = lemonCustomerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return  modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public  ModelAndView update(ModelAndView modelAndView, HttpServletRequest request)
    {
        LemonCustomer record = this.getRecord(request);

        String msg = this.validate(record);
        modelAndView.addObject("customer", record);

        if (msg != null && msg.length() > 0)
        {
            modelAndView.addObject("error", msg);
            return modelAndView;
        }

        int id = lemonCustomerService.update(record);

        return new ModelAndView("redirect: /customer/index");
    }

    private LemonCustomer getRecord(HttpServletRequest request)
    {
        LemonCustomer record = new LemonCustomer();

        String customerName = request.getParameter("customerName");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        int effective = Integer.parseInt(request.getParameter("effective"));
        String id = request.getParameter("id");

        record.setCustomerName(customerName);
        record.setMobile(mobile);
        record.setPassword(password);
        record.setEffective(effective);

        if (id != null)record.setId(Integer.parseInt(id));


        return  record;
    }

    private String validate(LemonCustomer customer)
    {
        String customerName = customer.getCustomerName();
        String mobile = customer.getMobile();
        String password = customer.getPassword();
        String msg = "";
        if (customerName == null || "".equals(customerName))
        {
            msg = "Customer ";
        }

        if (mobile == null || "".equals(mobile))
        {
            msg += "Mobile ";
        }

        if (password == null || "".equals(password))
        {
            msg += "Password ";
        }

        if (msg != "")
        {
            return msg + "can't be null!";
        } else
        {
            return msg;
        }
    }

    @RequestMapping("changeStatus")
    @ResponseBody
    public HashMap<String, Object> changeStatus(HttpServletRequest request)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        int effective = Integer.parseInt(request.getParameter("effective"));

        LemonCustomer customer = new LemonCustomer();

        customer.setId(id);
        customer.setEffective(effective);

        lemonCustomerService.update(customer);

        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("status", 1);

        return  hashMap;
    }
}
