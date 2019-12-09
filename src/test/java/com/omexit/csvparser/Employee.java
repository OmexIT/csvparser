package com.omexit.csvparser;

import com.omexit.csvparser.annotations.MaxLen;
import com.omexit.csvparser.annotations.MinLen;
import com.omexit.csvparser.annotations.NotNull;

import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

public class Employee {
    private int id;
    @NotNull
    @MaxLen(len = 20, message = "Should not be more than 20 characters")
    @MinLen(len = 2, message = "Should not be less than 2 characters")
    private String name;
    private Date dob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("dob=" + dob)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(name, employee.name) &&
                Objects.equals(dob, employee.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dob);
    }
}
