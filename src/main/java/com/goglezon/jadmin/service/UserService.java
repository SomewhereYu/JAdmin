package com.goglezon.jadmin.service;

import com.goglezon.jadmin.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuwenqi on 2015/9/13.
 */
@Service
public interface UserService {
    User get(User user);
    List<User> getUsersByGroup(int groupId);
    List<User> search(int groupId, String userName, int start, int pageSize);
    boolean update(String operator, User user);
    boolean create(String operator, User user) throws Exception;
    boolean delete(String operator, User user);
    User login(User user);
    boolean modifyUsersGroup(String operator, Map map);
}
