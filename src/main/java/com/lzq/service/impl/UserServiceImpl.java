package com.lzq.service.impl;

import com.lzq.dao.IBookshelfDao;
import com.lzq.dao.ICommentDao;
import com.lzq.dao.IMemoryDao;
import com.lzq.dao.IUserDao;
import com.lzq.domain.User;
import com.lzq.service.IUserService;
import com.lzq.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {
    //属性注入
    @Autowired
    private IUserDao userDao;
    @Autowired
    private IBookshelfDao bookshelfDao;
    @Autowired
    private IMemoryDao memoryDao;
    @Autowired
    private ICommentDao commentDao;

    @Override
    public int getCount(User user) {
        Map<String, Object> map = getQueryMap(user, null);
        return userDao.getCount(map);
    }

    @Override
    public List<User> queryUserList(User user, PageBean page) throws Exception {
        Map<String, Object> map = getQueryMap(user, page);
        return userDao.query(map);
    }

    @Override
    public int insertUser(User user) throws Exception {
        return userDao.insertUser(user);
    }

    @Override
    public int deleteUser(int id) throws Exception {
        memoryDao.deleteByUserId(id);
        bookshelfDao.deleteByUser(id);
        commentDao.deleteByUserId(id);
        return userDao.deleteUser(id);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return userDao.updateUser(user);
    }

    @Override
    public User queryUserById(int id) throws Exception {
        return userDao.queryUserById(id);
    }

    @Override
    public int updateSignIn(int id) throws Exception{
        return userDao.updateSignIn(id);
    }



    /**
     * 封装查询条件
     *
     * @param user
     * @param page
     * @return
     */
    private Map<String, Object> getQueryMap(User user, PageBean page) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (user != null) {
            map.put("id", user.getId());
            map.put("username", user.getUsername());
            map.put("name", user.getName());
            map.put("password", user.getPassword());
            map.put("role", user.getRole());
            map.put("signInNumber", user.getSignInNumber());
            map.put("signInTime", user.getSignInTime());
        }
        if (page != null) {
            PageBean.setPageMap(map, page);
        }
        return map;
    }

}
