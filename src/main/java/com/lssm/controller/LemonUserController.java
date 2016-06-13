package com.lssm.controller;

import com.lssm.model.LemonUser;
import com.lssm.model.LemonUserExample;
import com.lssm.service.LemonUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2016/6/13.
 */
@Controller
@RequestMapping("/user")
public class LemonUserController {
    @Resource
    LemonUserService lemonUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, RedirectAttributes attributes) throws  Exception
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        LemonUserExample lemonUserExample = new LemonUserExample();
        LemonUserExample.Criteria criteria = lemonUserExample.createCriteria();

        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);

        List<LemonUser> user = lemonUserService.login(lemonUserExample);

        if(!user.isEmpty())
        {
            return "redirect:/customer/index";
        } else
        {
            attributes.addAttribute("userName", userName);
            attributes.addAttribute("password", password);
            attributes.addAttribute("error", "login error");

            return "redirect:/index.jsp";
        }
    }
}
