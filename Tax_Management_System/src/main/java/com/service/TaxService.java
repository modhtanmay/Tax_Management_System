package com.service;
import org.springframework.stereotype.Service;

import com.model.UserClaim;
@Service
public interface TaxService {
	
	public double calculateTax(UserClaim userClaim);

}
