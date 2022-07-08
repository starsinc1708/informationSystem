package com.company.informationsystem.screen.request;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;

@UiController("Request.browse.by.initiator")
@UiDescriptor("request-browse-by-initiator.xml")
@LookupComponent("requestsTable")
public class RequestBrowseByInitiator extends StandardLookup<Request> {
}