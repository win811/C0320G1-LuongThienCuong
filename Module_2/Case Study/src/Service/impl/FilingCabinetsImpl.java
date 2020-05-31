package Service.impl;

import Service.FilingCabinetsInterface;
import commons.FuncWriteAndReadFileCSV;
import models.Employee;

import java.util.Stack;

public class FilingCabinetsImpl implements FilingCabinetsInterface {
    private static final String PATH_FILE_EMPLOYEE = "src/data/Employee.csv";
    private static Stack<Employee> filingCabinetsEmployeeStack = new Stack<>();

    static {

        String dataEmployee = FuncWriteAndReadFileCSV.readCsvFile(PATH_FILE_EMPLOYEE);
        String[] employeeArray = dataEmployee.split("\n");
        for (int i = 0; i < employeeArray.length; i++) {
            if (i == 0) {
                continue;
            }
            String[] aEmployee = employeeArray[i].split(",");
            Employee employee = new Employee();
            employee.setId(aEmployee[0]);
            employee.setNameEmployee(aEmployee[1]);
            employee.setBirthdayEmployee(aEmployee[2]);
            employee.setAddressEmployee(aEmployee[3]);
            filingCabinetsEmployeeStack.push(employee);
        }

    }


    @Override
    public Employee findEmployeeById(String id) {
        while (true) {
            Employee employee = filingCabinetsEmployeeStack.pop();
            if (employee == null) {
                break;
            }
            if (id.equals(employee.getId())) {
                return employee;
            }
        }
        return null;
    }
}
