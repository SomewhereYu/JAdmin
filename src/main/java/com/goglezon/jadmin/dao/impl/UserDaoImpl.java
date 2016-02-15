package com.goglezon.jadmin.dao.impl;

import com.goglezon.jadmin.dao.UserDao;
import com.goglezon.jadmin.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuwenqi on 2015/9/12.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SqlSession sqlSession;

    public User get(User user) {
        User retUser = sqlSession.selectOne("UserDao.get", user);
        return retUser;
    }

    public int insert(User user) {
        int ret = sqlSession.insert("UserDao.insert", user);
        return ret;
    }

    public User login(User user) {
        User retUser = sqlSession.selectOne("com.goglezon.jadmin.dao.UserDao.login", user);
        return retUser;
    }

    public List<User> getUsersByGroup(int groupId) {
        return sqlSession.selectList("UserDao.getUsersByGroup", groupId);
    }

    public int update(User user) {
        return sqlSession.update("UserDao.update",user);
    }

    public int delete(User user) {
        return sqlSession.delete("UserDao.delete", user);
    }

    public int modifyUsersGroup(Map map) {
        return sqlSession.update("UserDao.modifyUsersGroup", map);
    }

}
