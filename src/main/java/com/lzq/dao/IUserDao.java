package com.lzq.dao;

import com.lzq.domain.User;

import java.util.List;
import java.util.Map;

public interface IUserDao{
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> query(Map<String, Object> inputParam);

    /**
     * 查询用户记录数
     *
     * @param inputParam
     * @return
     */
    public int getCount(Map<String, Object> inputParam);

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    public int deleteUser(Integer id);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据ID查询记录
     *
     * @param id
     * @return
     */
    public User queryUserById(Integer id);

    public int updateSignIn(Integer id);

}
