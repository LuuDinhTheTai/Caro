package com.utc.btl.service.impl;

import com.utc.btl.dao.ISessionDao;
import com.utc.btl.entity.Session;
import com.utc.btl.service.ISessionService;
import com.utc.btl.service.base.impl.BaseService;

public class SessionService extends BaseService<Session, Long> implements ISessionService {

    public SessionService(ISessionDao dao) {
        super(dao);
    }
}
