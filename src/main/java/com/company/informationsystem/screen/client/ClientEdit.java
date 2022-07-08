package com.company.informationsystem.screen.client;

import com.company.informationsystem.services.ClientService;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {

    @Autowired
    private ClientService individualService;
    @Autowired
    private Notifications notifications;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Client client = getEditedEntity();
        if(individualService.isCorrectEmail(client.getEmail())){
            event.resume();
        }
        else {
            notifications.create().withCaption("The email is not correct.").show();
            event.preventCommit();
        }
    }
}