package com.goglezon.jadmin.service.impl;

import com.goglezon.jadmin.dao.SysLogDao;
import com.goglezon.jadmin.dao.UserDao;
import com.goglezon.jadmin.model.SysLog;
import com.goglezon.jadmin.model.User;
import com.goglezon.jadmin.service.UserService;
import com.goglezon.jadmin.util.MD5;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuwenqi on 2015/9/13.
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger= Logger.getLogger(UserServiceImpl.class);
    @Resource
    private UserDao userDao;
    @Resource
    private SysLogDao sysLogDao;

    public User get(User user){
        return userDao.get(user);
    }

    public List<User> getUsersByGroup(int groupId){
        return userDao.getUsersByGroup(groupId);
    }

    public List<User> search(int groupId,String userName,int start,int pageSize){
        return null;
    }

    @Transactional(rollbackFor= Exception.class,propagation= Propagation.REQUIRED)
    public boolean update(String operator,User user){
        int ret=userDao.update(user);
        if(ret>0) {
            SysLog sysLog = new SysLog();
            sysLog.setUserName(operator);
            sysLog.setAction(Thread.currentThread().getStackTrace()[1].getMethodName());
            sysLog.setClassName(this.getClass().getName());
            sysLog.setClassObj(user.toString());
            sysLog.setResult(ret + "");
            sysLogDao.insert(sysLog);
        }
        return ret>0?true:false;
    }

    @Transactional(rollbackFor= Exception.class,propagation= Propagation.REQUIRED)
    public boolean create(String operator,User user) throws Exception{
        int ret=userDao.insert(user);
        SysLog sysLog=new SysLog();
        sysLog.setUserName(operator);
        sysLog.setAction(Thread.currentThread().getStackTrace()[1].getMethodName());
        sysLog.setClassName(this.getClass().getName());
        sysLog.setClassObj(user.toString());
        sysLog.setResult(ret + "");
        sysLogDao.insert(sysLog);
        return ret>0?true:false;
    }

    @Transactional(rollbackFor= Exception.class,propagation= Propagation.REQUIRED)
    public boolean delete(String operator,User user){
        int ret=userDao.delete(user);
        if(ret>0) {
            SysLog sysLog = new SysLog();
            sysLog.setUserName(operator);
            sysLog.setAction(Thread.currentThread().getStackTrace()[1].getMethodName());
            sysLog.setClassName(this.getClass().getName());
            sysLog.setClassObj(user.toString());
            sysLog.setResult(ret + "");
            sysLogDao.insert(sysLog);
        }
        return ret>0?true:false;
    }
    public User login(User user){
        user.setPassword(MD5.md5(user.getPassword()));
        User retUser=userDao.login(user);
        return retUser;
    }

    public boolean modifyUsersGroup(String operator,Map map){
        int ret=userDao.modifyUsersGroup(map);
        if(ret>0){
            SysLog sysLog = new SysLog();
            sysLog.setUserName(operator);
            sysLog.setAction(Thread.currentThread().getStackTrace()[1].getMethodName());
            sysLog.setClassName(this.getClass().getName());
            sysLog.setClassObj("userGroup:"+map.get("userGroup")+";userIds:"+map.get("userIds").toString());
            sysLog.setResult(ret + "");
            sysLogDao.insert(sysLog);
        }
        return ret>0?true:false;
    }
}
