package com.company.informationsystem.services;

import com.company.informationsystem.entity.Employee;
import com.company.informationsystem.entity.Initiator;
import com.company.informationsystem.entity.Request;
import com.company.informationsystem.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.querycondition.PropertyCondition;
import io.jmix.core.security.CurrentAuthentication;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsService {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    public List<Request> requestsByExecutor (UserDetails user) {
        return dataManager.load(Request.class)
                .query("select r from Request r where r.executor.systemUser.username like :username")
                .parameter("username", user.getUsername())
                .list();
    }

    public void createRequest (Request request) {

    }
}
