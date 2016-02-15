package com.goglezon.jadmin.dao;

import com.goglezon.jadmin.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuwenqi on 2015/9/12.
 */
@Repository
public interface UserDao {
    User get(User user);
    int insert(User user);
    User login(User user);
    List<User> getUsersByGroup(int groupId);
    int update(User user);
    int delete(User user);
    int modifyUsersGroup(Map map);
}
