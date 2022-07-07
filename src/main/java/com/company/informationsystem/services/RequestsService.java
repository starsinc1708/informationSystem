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

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(RequestsService.class);
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;


    public List<Request> requestsByExecutor (/*User user*/) {

        /*Initiator initiator = dataManager.load(Employee.class)
                .condition(PropertyCondition
                        .equal("firstName", user.getFirstName())).one();
        System.out.println(initiator.getFirstName() + initiator.getId());*/

        /*return dataManager.load(Request.class)
                .query("select r from Request r where r.executor.firstName like :firstName")
                .parameter("firstName", initiator.getFirstName())
                .list();*/
        UserDetails user = currentAuthentication.getUser();
        Authentication authentication = currentAuthentication.getAuthentication();

        User sysUser = dataManager.load(User.class)
                .query("select u from User u where u.username = :username")
                .parameter("username", currentAuthentication.getUser().getUsername())
                .one();

        log.info(sysUser.getLastName());

        return dataManager.load(Request.class)
                .all()
                .list();
    }
}
