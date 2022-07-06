package com.company.informationsystem.screen.initiator;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Initiator;

@UiController("Initiator.browse")
@UiDescriptor("initiator-browse.xml")
@LookupComponent("initiatorsTable")
public class InitiatorBrowse extends StandardLookup<Initiator> {
}