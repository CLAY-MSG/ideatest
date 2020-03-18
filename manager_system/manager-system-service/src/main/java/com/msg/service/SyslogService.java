package com.msg.service;

import com.msg.domain.Syslog;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/13 0:06
 */
public interface SyslogService {

    public void save(Syslog syslog);

    List<Syslog> findAll();
}
