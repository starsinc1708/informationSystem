package com.company.informationsystem.screen.employee;

import io.jmix.ui.screen.*;
import com.company.informationsystem.entity.Employee;

@UiController("Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
public class EmployeeBrowse extends StandardLookup<Employee> {
}