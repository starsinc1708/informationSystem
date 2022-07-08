package com.company.informationsystem.screen.request;

import com.company.informationsystem.entity.Employee;
import com.company.informationsystem.entity.Initiator;
import com.company.informationsystem.entity.User;
import com.company.informationsystem.services.RequestsService;
import io.jmix.core.DataManager;
import io.jmix.core.LoadContext;
import io.jmix.core.querycondition.PropertyCondition;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Locale;

@UiController("Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
public class RequestBrowse extends StandardLookup<Request> {

    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;
    @Autowired
    private RequestsService requestsService;

    private UserDetails user;

    @Subscribe
    private void onInit(InitEvent event) {
        user = currentAuthentication.getUser();
    }

    @Install(to = "requestsDl", target = Target.DATA_LOADER)
    private List<Request> requestsDlLoadDelegate(LoadContext<Request> loadContext) {
        return requestsService.requestsByExecutor(user);
    }
}