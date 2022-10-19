package com.lzq.web.controller;

import com.lzq.domain.Admin;
import com.lzq.service.IAdminService;
import com.lzq.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    /**
     * 管理员列表
     * @param request
     * @param username
     * @param password
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request,
                       @RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "password", required = false) String password,
                       Admin admin) throws Exception {
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
        admin.setUsername(username);
        request.setAttribute("username", username);
        admin.setPassword(password);
        request.setAttribute("password", password);
        // 查询记录总数
        counts = adminService.getCount(admin);
        // 获取当前页记录
        List adminList = adminService.queryAdminList(admin, page);
        request.setAttribute("list", adminList);
        // 将分页相关参数放到request中
        request.setAttribute("itemSize", counts);
        int page_count = counts % PageBean.PAGE_IETM == 0 ? counts
                / PageBean.PAGE_IETM : counts / PageBean.PAGE_IETM + 1;
        request.setAttribute("pageItem", PageBean.PAGE_IETM);
        request.setAttribute("pageTotal", page_count);
        return "/tadmin/tadmin_list";
    }

    /**
     * 跳转到添加页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toAdd")
    public String toAdd(HttpServletRequest request) throws Exception {
        return "/tadmin/tadmin_add";
    }

    /**
     * 添加方法
     * @param admin
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add")
    public String add(Admin admin, HttpServletRequest request)
            throws Exception {
        // 保存到数据库
        adminService.insertAdmin(admin);
        return "redirect:/admin/list";
    }

    /**
     * 更新用户信息
     * @param admin
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update")
    public String update(Admin admin, HttpServletRequest request)
            throws Exception {
        // 更新数据库
        adminService.updateAdmin(admin);
        return "redirect:/admin/list";
    }

    /**
     * 管理员更新页面
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/toUpdate")
    public ModelAndView toUpdate(@RequestParam("id") int id) throws Exception {
        ModelAndView mv = new ModelAndView("/tadmin/tadmin_update");
        Admin admin = adminService.queryAdminById(id);
        mv.addObject("admin", admin);

        return mv;
    }

    /**
     * 删除管理员
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") int id) throws Exception {
        adminService.deleteAdmin(id);
        return "redirect:/admin/list";
    }

    /**
     * 用户名是否存在验证
     * @param username
     * @param admin
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/usernameExist")
    public String usernameExist(@RequestParam("username") String username, Admin admin) throws Exception {
        String exist = "true";
        admin.setUsername(username);
        List list = adminService.queryAdminList(admin, null);
        if (list.size() != 0) {
            exist = "false";
        }
        return exist;
    }

    /**
     * 更新密码
     * @param password
     * @param request
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updatePassword")
    public String updatePassword(@RequestParam("password") String password,
                                 HttpServletRequest request, Admin admin) throws Exception {
        admin.setPassword(password);
        adminService.updateAdmin(admin);
        request.getSession().setAttribute("user", admin);
        return "redirect:/admin/list";
    }

    /**
     * 跳转到密码修改页面
     * @return
     */
    @RequestMapping(value = "/upwd")
    public String toUpwd() {
        return "/tadmin/tadmin_upwd";
    }

    /**
     * 查看管理员详细信息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/toView")
    public ModelAndView toView(@RequestParam("id") int id) throws Exception{
        ModelAndView mv = new ModelAndView("tadmin/tadmin_view");
        Admin admin = adminService.queryAdminById(id);
        mv.addObject("admin", admin);
        return mv;
    }
}
