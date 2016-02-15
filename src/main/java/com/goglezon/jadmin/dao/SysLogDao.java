package com.goglezon.jadmin.dao;

import com.goglezon.jadmin.model.SysLog;
import org.springframework.stereotype.Repository;

/**
 * Created by Yuwenqi on 2015/9/12.
 */
@Repository
public interface SysLogDao {
    int insert(SysLog sysLog);
}
