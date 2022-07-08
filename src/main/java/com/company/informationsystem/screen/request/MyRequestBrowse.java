package com.company.informationsystem.screen.request;

import com.company.informationsystem.services.RequestsService;
import io.jmix.core.LoadContext;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@UiController("MyRequest.browse")
@UiDescriptor("my-request-browse.xml")
@LookupComponent("requestsTable")
public class MyRequestBrowse extends StandardLookup<Request> {

    @Autowired
    private RequestsService requestsService;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    private UserDetails user;

    @Subscribe
    private void onInit(InitEvent event) {
        user = currentAuthentication.getUser();
    }

    @Install(to = "requestsDl", target = Target.DATA_LOADER)
    private List<Request> requestsDlLoadDelegate(LoadContext<Request> loadContext) {
        return requestsService.requestsByInitiator(user);
    }
}