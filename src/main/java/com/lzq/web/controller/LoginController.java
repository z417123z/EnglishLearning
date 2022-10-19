package com.lzq.web.controller;

import com.lzq.domain.Admin;
import com.lzq.domain.User;
import com.lzq.service.IAdminService;
import com.lzq.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/login")
@SessionAttributes(value = {"user"})
public class LoginController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IAdminService adminService;

    //转向登陆页面
    @RequestMapping(value = "/loginInput", method = RequestMethod.GET)
    public String loginInput() {
        return "login";
    }


    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/login.do")
    public @ResponseBody
    String login(@RequestParam("username") String username,
                 @RequestParam String password,
                 @RequestParam("utype") int utype,
                 HttpServletRequest request,Model model,
                 HttpSession session) throws Exception {
        String flag = "false";
        //int type = Integer.parseInt(request.getParameter("type"));
        if (utype == 0) {
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            List<Admin> adminList = adminService.queryAdminList(admin, null);
            if (adminList != null && adminList.size() > 0) {
                Admin admin1 = adminList.get(0);
                model.addAttribute("user", admin1);
                request.getSession().setAttribute("user", admin1);
                int id = admin1.getId();
                session.setAttribute("userId", id);
                flag = "true";
            }
        }
        if (utype == 1) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            List<User> userList = userService.queryUserList(user, null);
            if (userList != null && userList.size() > 0) {
                User users = userList.get(0);
                request.getSession().setAttribute("user",users);
                int id = users.getId();
                session.setAttribute("userId", id);
                model.addAttribute("user", users);
                flag = "true";

            }
        }
        model.addAttribute("utype", utype);
        request.getSession().setAttribute("utype", utype);
        return flag;
    }

    /**
     * 退出登陆
     */
    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/login/loginInput";
    }

    /**
     * 验证用户存在
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/userExist")
    public String userExist(@RequestParam("username") String username) throws Exception {
        String exist = "true";
        User user = new User();
        user.setUsername(username);
        List<User> list = userService.queryUserList(user, null);
        if (list != null && list.size() > 0) {
            exist = "false";
        }
        return exist;
    }

    //转到登陆成功页面
    @RequestMapping(value = "/loginSuccess")
    public String loginSuccess() {
        return "index";
    }

    //注册
    @RequestMapping(value = "/userReg")
    public String userReg(User user, HttpServletRequest request)
            throws Exception {
        // 保存到数据库
        userService.insertUser(user);
        return "redirect:/login/loginInput";
    }

    //跳转
    @RequestMapping(value = "/left")
    public String left() {
        return "left";
    }

    @RequestMapping(value = "/top")
    public ModelAndView top(HttpSession session) throws Exception {
        ModelAndView mv = new ModelAndView("/top");
        int userId = (Integer)session.getAttribute("userId");
        mv.addObject("id", userId);
        return mv;
    }

    @RequestMapping(value = "/tag")
    public String tag() {
        return "common/pagination_tag";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }


}