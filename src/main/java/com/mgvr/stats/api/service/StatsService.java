package com.mgvr.stats.api.service;

import com.mgvr.stats.api.dao.KudoDao;
import com.mgvr.stats.api.dao.UserDao;
import com.mgvr.stats.api.model.kudo.model.Kudo;
import com.mgvr.stats.api.model.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StatsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private KudoDao kudoDao;

    public void updateKudosStats(String realName){
        int nroKudos = getNumberOfKudosByRealName(realName);

        updateStatsByUserRealName(realName, nroKudos);
    }

    private int getNumberOfKudosByRealName(String realName){
        return kudoDao.getNumberOfKudosByUser(realName);
    }

    private void updateStatsByUserRealName(String realName, int nroKudos){
        userDao.updateUserStats(realName, nroKudos);
    }
}
