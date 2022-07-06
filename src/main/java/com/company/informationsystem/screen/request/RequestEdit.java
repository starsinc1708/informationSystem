package com.company.informationsystem.screen.request;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;

@UiController("Request.edit")
@UiDescriptor("request-edit.xml")
@EditedEntityContainer("requestDc")
public class RequestEdit extends StandardEditor<Request> {
}