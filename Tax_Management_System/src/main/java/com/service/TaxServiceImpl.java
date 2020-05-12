package com.service;

import org.springframework.stereotype.Service;

import com.model.UserClaim;

@Service
public class TaxServiceImpl implements TaxService {

	@Override
	public double calculateTax(UserClaim userClaim) {
		
		double taxamount=0.0;
		if (userClaim.getExpenseType().equalsIgnoreCase("MedicalExpense")) {

			if (userClaim.getExpenseAmt() < 1000) {
				
				taxamount= userClaim.getExpenseAmt()*(0.15);

			}
			else if (userClaim.getExpenseAmt() > 1000 && userClaim.getExpenseAmt() < 10000) {
				taxamount= userClaim.getExpenseAmt()*(0.20);
			}
			else {
				taxamount= userClaim.getExpenseAmt()*(0.25);
			}

		} else if (userClaim.getExpenseType().equalsIgnoreCase("TravelExpense")) {
			if (userClaim.getExpenseAmt() < 1000) {
				taxamount= userClaim.getExpenseAmt()*(0.10);
			}
			else if (userClaim.getExpenseAmt() > 1000 && userClaim.getExpenseAmt() < 10000) {
				taxamount= userClaim.getExpenseAmt()*(0.15);
			}
			else {
				taxamount= userClaim.getExpenseAmt()*(0.20);
			}

		} else {
			if (userClaim.getExpenseAmt() < 1000) {
				taxamount= userClaim.getExpenseAmt()*(0.05);
			}
			else if (userClaim.getExpenseAmt() > 1000 && userClaim.getExpenseAmt() < 10000) {
				taxamount= userClaim.getExpenseAmt()*(0.10);
			}
			else {
				taxamount= userClaim.getExpenseAmt()*(0.15);
			}
		}

		return taxamount;
	}

}
