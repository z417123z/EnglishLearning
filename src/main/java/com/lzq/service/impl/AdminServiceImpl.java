package com.lzq.service.impl;

import com.lzq.dao.IAdminDao;
import com.lzq.domain.Admin;
import com.lzq.service.IAdminService;
import com.lzq.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminDao adminDao;

    /**
     * 查询管理员信息记录数
     *
     * @param admin
     * @return
     */
    public int getCount(Admin admin) {
        Map<String, Object> map = getQueryMap(admin, null);
        return adminDao.getCount(map);
    }

    /**
     * 查询所有管理员信息
     *
     * @return
     */
    public List<Admin> queryAdminList(Admin admin, PageBean page)
            throws Exception {
        Map<String, Object> map = getQueryMap(admin, page);
        List<Admin> list = adminDao.query(map);
        return list;
    }

    /**
     * 封装查询条件
     *
     * @param admin
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(Admin admin, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (admin != null) {
            map.put("id", admin.getId());
            map.put("username", admin.getUsername());
            map.put("password", admin.getPassword());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

    /**
     * 保存管理员信息
     *
     * @param admin
     * @return
     */
    public int insertAdmin(Admin admin) throws Exception {
        return adminDao.insertAdmin(admin);
    }

    /**
     * 删除管理员信息
     *
     * @param id
     * @return
     */
    public int deleteAdmin(int id) throws Exception {
        return adminDao.deleteAdmin(id);
    }

    /**
     * 更新管理员信息
     *
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin) throws Exception {
        return adminDao.updateAdmin(admin);
    }

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Admin queryAdminById(int id) throws Exception {
        return adminDao.queryAdminById(id);
    }
}
