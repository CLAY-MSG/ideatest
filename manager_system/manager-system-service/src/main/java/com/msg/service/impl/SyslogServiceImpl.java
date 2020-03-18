package com.msg.service.impl;

import com.msg.dao.SyslogDao;
import com.msg.domain.Syslog;
import com.msg.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/13 0:07
 */
@Service
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SyslogDao syslogDao;

    @Override
    public void save(Syslog syslog) {
        syslogDao.save(syslog);
    }

    @Override
    public List<Syslog> findAll() {
        return syslogDao.findAll();
    }
}
