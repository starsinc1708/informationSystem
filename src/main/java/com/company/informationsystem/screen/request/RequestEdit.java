package com.company.informationsystem.screen.request;

import com.company.informationsystem.entity.*;
import com.company.informationsystem.services.RequestsService;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.core.security.CurrentAuthentication;
import io.jmix.ui.builder.EditMode;
import io.jmix.ui.component.*;
import io.jmix.ui.screen.*;
import liquibase.pro.packaged.S;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.*;

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
    @Autowired
    private TextField<String> descriptionField;
    @Autowired
    private DateField<LocalDate> openDateField;
    @Autowired
    private DateField<LocalDate> closeDateField;
    @Autowired
    private EntityPicker<Initiator> initiatorField;
    @Autowired
    private EntityPicker<Employee> executorField;


    private Employee currentUser;

    @Subscribe
    public void onInit(InitEvent event) {
        currentUser = dataManager.load(Employee.class)
                .query("select e from Employee e where e.systemUser.username = :username")
                .parameter("username", currentAuthentication.getUser().getUsername())
                .one();

        requestStatusField.setEditable(false);
        descriptionField.setEditable(false);
        openDateField.setEditable(false);
        closeDateField.setEditable(false);
        initiatorField.setEditable(false);
        executorField.setEditable(false);

        List<String> list = new ArrayList<>();
        list.add("Открыта");
        list.add("На рассмотрении");
        list.add("На согласовании");
        list.add("На утверждении");
        list.add("Закрыта");
        requestStatusField.setOptionsList(list);
    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {
        if(dataManager.load(Request.class)
                .id(getEditedEntity().getId())
                .optional()
                .isPresent()) {
            if(Objects.equals(currentUser.getId(), getEditedEntity().getInitiator().getId())) {
                requestStatusField.setEditable(true);
                descriptionField.setEditable(true);
                openDateField.setEditable(true);
                closeDateField.setEditable(true);
                initiatorField.setEditable(true);
                executorField.setEditable(true);
            }
            if (dataManager.load(Client.class).id(getEditedEntity().getInitiator().getId())
                    .optional()
                    .isPresent()){
                requestStatusField.setEditable(true);
            }
        }
    }


    @Subscribe
    public void onInitEntity(InitEntityEvent<Request> event) {
        requestStatusField.setEditable(true);
        descriptionField.setEditable(true);
        openDateField.setEditable(true);
        closeDateField.setEditable(true);
        initiatorField.setEditable(true);
        executorField.setEditable(true);
        if(!Objects.equals(currentAuthentication.getUser().getUsername(), "admin")) {
            initiatorField.setEditable(false);
            event.getEntity().setInitiator(currentUser);
        }
    }
}