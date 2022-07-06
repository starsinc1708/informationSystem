package com.company.informationsystem.screen.client;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Client;

@UiController("Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
public class ClientEdit extends StandardEditor<Client> {
}