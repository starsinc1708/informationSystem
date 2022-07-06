package com.company.informationsystem.screen.initiator;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Initiator;

@UiController("Initiator.edit")
@UiDescriptor("initiator-edit.xml")
@EditedEntityContainer("initiatorDc")
public class InitiatorEdit extends StandardEditor<Initiator> {
}