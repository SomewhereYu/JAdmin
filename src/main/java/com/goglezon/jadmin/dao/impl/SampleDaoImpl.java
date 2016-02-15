package com.goglezon.jadmin.dao.impl;

import com.goglezon.jadmin.dao.SampleDao;
import com.goglezon.jadmin.model.Sample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Yuwenqi on 2015/9/12.
 */
@Repository
public class SampleDaoImpl implements SampleDao {
    @Autowired
    private SqlSession sqlSession;

    public Sample getSample(Sample sample) {
        Sample retUser=sqlSession.selectOne("SampleDao.getSample", sample);
        return retUser;
    }
}
