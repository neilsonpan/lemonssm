package com.lssm.controller;

import com.lssm.model.LemonCustomer;
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
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
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
    public String login(HttpServletRequest request, RedirectAttributes attributes, HttpSession session) throws  Exception
    {
        if (session.getAttribute("id") != null)
        {
            return "redirect:/customer/index";
        }

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String validate = "";
        if ("".equals(userName) || userName == null)
        {
            validate = "User Name ";
        }

        if ("".equals(password) || password == null)
        {
            attributes.addAttribute("userName", userName);
            validate += "Password ";
        }

        if (validate != "")
        {
            attributes.addAttribute("error", validate + "can't be null!");
            return "redirect:/index.jsp";
        }

        LemonUserExample lemonUserExample = new LemonUserExample();
        LemonUserExample.Criteria criteria = lemonUserExample.createCriteria();

        criteria.andUsernameEqualTo(userName);
        criteria.andPasswordEqualTo(password);

        List<LemonUser> user = lemonUserService.login(lemonUserExample);

        if(!user.isEmpty())
        {
            Iterator iterator = user.iterator();

            while (iterator.hasNext())
            {
                LemonUser uelement= (LemonUser) iterator.next();
                session.setAttribute("id", uelement.getId());
            }

            return "redirect:/customer/index";
        } else
        {
            attributes.addAttribute("userName", userName);
            attributes.addAttribute("password", password);

            attributes.addAttribute("error", "User name or Password wrong!");

            return "redirect:/index.jsp";
        }
    }
}
