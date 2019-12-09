package com.omexit.csvparser;

import com.omexit.csvparser.exceptions.ValidationException;
import org.junit.BeforeClass;
import org.junit.Test;

import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class AnnotationTests {

    static CSVReader<Employee> csvReader;

    @BeforeClass
    public static void setUp() throws Exception {
        csvReader=new CSVReader<Employee>( new EmployeeFieldsetMapper());
    }

    public void maxLenSuccessTest() throws Exception {
        String line = "3,Test Three,11-08-1996";
        Employee actualEmployee = csvReader.readLine(line);
        Employee employee=new Employee();
        employee.setId(3);
        employee.setName("Test Three");
        employee.setDob(new SimpleDateFormat("dd-MM-yyyy").parse("11-08-1996"));

        assertEquals(employee, actualEmployee);
    }

    @Test(expected = ValidationException.class)
    public void maxLenFailedTest() throws Exception {
        String line = "3,Test Three More Name to Infinitynn,11-08-1996";
        csvReader.readLine(line);
    }
}
