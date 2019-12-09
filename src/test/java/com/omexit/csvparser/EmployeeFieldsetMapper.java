package com.omexit.csvparser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EmployeeFieldsetMapper implements FieldsetMapper<Employee> {

    public Employee map(FieldSet fieldSet) throws Exception {
        Employee employee=new Employee();
        employee.setId(fieldSet.readInt(0));
        employee.setName(fieldSet.readString(1));
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        employee.setDob(fieldSet.readDate(2, dateFormat));
        return employee;
    }
}
