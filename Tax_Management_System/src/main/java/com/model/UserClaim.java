package com.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

public class UserClaim {
	
	private String expenseType;
	@Positive(message = "{error.expenseAmount.negative}" )
	@Min(value = 0,message = "{error.expenseAmount.numeric}")
	@Range(min = 1,message ="{error.employeeId}" )
	private double expenseAmt;
	@NotEmpty(message = "{error.employeeId}")
	private String employeeId;
	
	public UserClaim() {
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public double getExpenseAmt() {
		return expenseAmt;
	}
	public void setExpenseAmt(double expenseAmt) {
		this.expenseAmt = expenseAmt;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
	
}
