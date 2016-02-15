package com.goglezon.jadmin.service;

import com.goglezon.jadmin.dao.SysLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Yuwenqi on 2015/9/13.
 */
@Service
public class SysLogService {
    @Resource
    private SysLogDao sysLogDao;

}
