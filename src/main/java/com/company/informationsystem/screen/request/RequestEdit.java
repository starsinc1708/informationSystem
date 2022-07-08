package com.company.informationsystem.screen.request;

import com.company.informationsystem.entity.Initiator;
import com.company.informationsystem.services.RequestsService;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;
import liquibase.pro.packaged.S;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@UiController("Request.edit")
@UiDescriptor("request-edit.xml")
@EditedEntityContainer("requestDc")
public class RequestEdit extends StandardEditor<Request> {
    @Autowired
    private ComboBox<String> requestStatusField;
    @Autowired
    private RequestsService requestsService;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private CurrentAuthentication currentAuthentication;

    @Subscribe
    public void onInit(InitEvent event) {
        List<String> list = new ArrayList<>();
        list.add("Open");
        list.add("Under consideration");
        list.add("On approval");
        list.add("Closed");
        requestStatusField.setOptionsList(list);
    }
}