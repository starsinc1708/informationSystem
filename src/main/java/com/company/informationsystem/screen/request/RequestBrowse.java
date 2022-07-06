package com.company.informationsystem.screen.request;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;

@UiController("Request.browse")
@UiDescriptor("request-browse.xml")
@LookupComponent("requestsTable")
public class RequestBrowse extends StandardLookup<Request> {
}