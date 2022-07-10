package com.company.informationsystem.screen.client;

import com.company.informationsystem.services.ClientService;
import io.jmix.core.Messages;
import io.jmix.ui.Notifications;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {

    @Autowired
    private ClientService clientService;
    @Autowired
    private Notifications notifications;
    @Autowired
    private Messages messages;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Client client = getEditedEntity();
        if(clientService.isCorrectEmail(client.getEmail())){
            event.resume();
        }
        else {
            notifications.create().withCaption(messages.getMessage("com.company.informationsystem.screen.client", "theEmailIsNotCorrect")).show();
            event.preventCommit();
        }
    }
}