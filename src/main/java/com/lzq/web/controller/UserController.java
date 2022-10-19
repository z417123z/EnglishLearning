package com.lzq.web.controller;


import com.lzq.domain.User;
import com.lzq.service.IUserService;
import com.lzq.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 用户列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request,
                       @RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "password", required = false) String password,
                       @RequestParam(value = "name", required = false) String name,
                       User user) throws Exception {
        /**
         * 获取分页参数
         */
        int offset = 0; // 记录偏移量
        int counts = 0; // 总记录数
        try {
            offset = Integer.parseInt(request.getParameter("pager.offset"));
        } catch (Exception e) {
        }
        PageBean page = new PageBean(offset);
        //user.setRole(1);
        // 查询记录总数
        counts = userService.getCount(user);
        // 获取当前页记录
        List userList = userService.queryUserList(user, page);
        request.setAttribute("list", userList);
        // 将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
                / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/user/user_list";
    }

    /**
     * 跳转到新增用户界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        return "/user/user_add";
    }

    /**
     * 保存新增用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public String add(User user) throws Exception {
        // 保存到数据库
        user.setRole(1);
        userService.insertUser(user);
        return "redirect:/user/user_list";
    }

    /**
     * 跳转到更新用户界面
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toUpdate")
    public String toUpdate(HttpServletRequest request) throws Exception {
        int id = Integer.parseInt(request.getParameter("id"));
        // 根据ID查询出需要更新的记录
        User user = userService.queryUserById(id);
        request.setAttribute("user", user);
        return "/user/user_update";
    }

    /**
     * 更新用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update")
    public String update(User user,Model model)
            throws Exception {
        // 更新数据库
        userService.updateUser(user);
        return "/user/user_info";
    }

    /**
     * 删除用户
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    public String delete(HttpServletRequest request) throws Exception {
        // 根据id删除数据库记录
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    /**
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user_info")
    public ModelAndView info(HttpSession session)
            throws Exception {
        ModelAndView mv = new ModelAndView("/user/user_info");
        int Id = (Integer) session.getAttribute("userId");
        User user = userService.queryUserById(Id);
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/userUpdate")
    public ModelAndView userUpdate(@RequestParam("userId") int id)
            throws Exception {
        ModelAndView mv = new ModelAndView("/user/user_info");
        User user = userService.queryUserById(id);
        mv.addObject("user", user);
        return mv;
    }

    /**
     * 用户名是否存在
     * @param username
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/usernameExist")
    public String usernameExist(@RequestParam("username") String username, User user) throws Exception {
        String exist = "true";
        user.setUsername(username);
        List list = userService.queryUserList(user, null);
        if (null != list && !list.isEmpty()) {
            exist = "false";
        }
        return exist;
    }

    /**
     * 更新密码
     * @param password
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updatePassword")
    public ModelAndView updatePassword(@RequestParam("password") String password,
                                       User user) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/user/user_info");
        user.setPassword(password);
        userService.updateUser(user);
        return mv;
    }

    /**
     * 跳转到更新密码页面
     * @param id
     * @param session
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toUpdatePassword")
    public ModelAndView toUpdatePassword(@RequestParam("id") int id,
                                         HttpSession session, User user) throws Exception {
        ModelAndView mv = new ModelAndView("/user/user_upwd");
        user = userService.queryUserById(id);
        mv.addObject("user", user);
        return mv;
    }

    /**
     * 每日签到模块
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "signIn")
    public String updateSignIn(@RequestParam("id") int id) throws Exception {

        User user = userService.queryUserById(id);
        Date click = user.getSignInTime();
        String msg = "true";

        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        // new Date()为获取当前系统时间
        if ( df.format(new Date()).equals(df.format(click)) ){
            msg = "error";
        }else{
            userService.updateSignIn(id);
        }

        return msg;
    }


}
