package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Employee;

public class DefaultApiImpl implements DefaultApi {

	@Override
	public Employee employeeGet() {
		// TODO Auto-generated method stub
		Employee myemp=new Employee();
		myemp.setCategory("brandnew");
		myemp.setId(100040);
		myemp.setName("kavitha from real backend service impl");
		myemp.setRegion("NA Sales");
		return myemp;
	}

	@Override
	public Employee employeePost(Employee body) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Employee employeePut(Employee body) {
		// TODO Auto-generated method stub
		return null;
	}

}
