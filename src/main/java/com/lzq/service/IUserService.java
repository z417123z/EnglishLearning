package com.lzq.service;

import com.lzq.domain.User;
import com.lzq.utils.PageBean;

import java.util.List;

public interface IUserService {
    /**
     * 查询用户记录数
     *
     * @param user
     * @return
     */
    public int getCount(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> queryUserList(User user, PageBean page) throws Exception;

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user) throws Exception;

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUser(int id) throws Exception;

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public int updateUser(User user) throws Exception;

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public User queryUserById(int id) throws Exception;

    public int updateSignIn(int id) throws Exception;

}
