package com.company.informationsystem.screen.request;

import com.company.informationsystem.entity.Employee;
import com.company.informationsystem.entity.User;
import com.company.informationsystem.services.RequestsService;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.core.querycondition.PropertyCondition;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
public class RequestBrowse extends StandardLookup<Request> {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    private User user;
    private Employee employee;

    @Autowired
    private RequestsService requestsService;

    @Subscribe
    private void onInit(Screen.InitEvent event) {
        /*user = dataManager.load(User.class)
                .condition(PropertyCondition
                        .equal("username", currentAuthentication.getUser().getUsername())).one();
        System.out.println(user.getUsername());*/
    }

    @Install(to = "requestsDl", target = Target.DATA_LOADER)
    private List<Request> requestsDlLoadDelegate(LoadContext<Request> loadContext) {
        return requestsService.requestsByExecutor();
    }
}