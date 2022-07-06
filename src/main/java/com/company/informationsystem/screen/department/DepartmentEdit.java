package com.company.informationsystem.screen.department;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Department;

@UiController("Department.edit")
@UiDescriptor("department-edit.xml")
@EditedEntityContainer("departmentDc")
public class DepartmentEdit extends StandardEditor<Department> {
}