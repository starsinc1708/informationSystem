package com.company.informationsystem.screen.request;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Request;

@UiController("MyRequest.edit")
@UiDescriptor("my-request-edit.xml")
@EditedEntityContainer("requestDc")
public class MyRequestEdit extends StandardEditor<Request> {

}