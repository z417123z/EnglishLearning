package com.lzq.dao;

import com.lzq.domain.Admin;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
    /**
     * 查询所有管理员信息
     *
     * @return
     */
    public List<Admin> query(Map<String, Object> inputParam);

    /**
     * 查询管理员信息记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存管理员信息
     *
     * @param admin
     * @return
     */
    public int insertAdmin(Admin admin);

    /**
     * 删除管理员信息
     *
     * @param id
     * @return
     */
    public int deleteAdmin(Integer id);

    /**
     * 更新管理员信息
     *
     * @param admin
     * @return
     */
    public int updateAdmin(Admin admin);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public Admin queryAdminById(Integer id);
}
