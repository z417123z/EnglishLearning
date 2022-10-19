package com.lzq.service;

import com.lzq.domain.Admin;
import com.lzq.utils.PageBean;

import java.util.List;

public interface IAdminService {
    /**
     * 查询管理员信息记录数
     *
     * @param admin
     * @return
     */
    public int getCount(Admin admin);

    /**
     * 查询所有管理员信息
     *
     * @return
     */
    public List<Admin> queryAdminList(Admin admin, PageBean page)
            throws Exception;

    /**
     * 保存管理员信息
     *
     * @param admin
     * @return
     */
    public int insertAdmin(Admin admin) throws Exception;

    /**
     * 删除管理员信息
     *
     * @param id
     * @return
     */
    public int deleteAdmin(int id) throws Exception;

    /**
     * 更新管理员信息
     *
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Admin queryAdminById(int id) throws Exception;
}
