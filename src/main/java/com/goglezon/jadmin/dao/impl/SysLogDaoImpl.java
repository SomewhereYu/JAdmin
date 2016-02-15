package com.goglezon.jadmin.dao.impl;

import com.goglezon.jadmin.model.SysLog;
import com.goglezon.jadmin.dao.SysLogDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yuwenqi on 2015/9/13.
 */
@Repository
public class SysLogDaoImpl implements SysLogDao {
    @Autowired
    private SqlSession sqlSession;
    public int insert(SysLog sysLog){
        return sqlSession.insert("SysLogDao.insert",sysLog);
    }
}
