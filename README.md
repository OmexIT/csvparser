# Demo project for CSV Parser in Java

Sample usage:
Given the following CSV file:
```csv
1,Test One,22-06-1985
2,Test Two,12-05-1992
3,Test Three,11-08-1996
4,Test Four,06-06-1974
```

1. Create Employee object

```java
public class Employee {
      private int id;
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
  }
```

2. Create object mapper by implementing **FieldsetMapper<T>** interface

```java
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
```

3. Sample main class
```java
public class MainTest {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/dev/csvparser/src/main/resources/employees.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));

        CSVReader<Employee> csvReader=new CSVReader<Employee>( new EmployeeFieldsetMapper());
        String line;
        while((line = reader.readLine()) != null) {
            System.err.println(csvReader.readLine(line));
        }
    }
}
```