package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Employee;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //GET_employee
    public Employee employeeGet();
    
    //POST_employee
    public Employee employeePost(Employee body);
    
    //PUT_employee
    public Employee employeePut(Employee body);
    
}
