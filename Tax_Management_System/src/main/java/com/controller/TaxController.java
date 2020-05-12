package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.UserClaim;
	import com.service.TaxService;

@Controller
public class TaxController {
	
	@Autowired
	private TaxService taxService;
	
	@RequestMapping("/getTaxClaimFormPage")
	public String claimPage(@ModelAttribute("userClaim") UserClaim userClaim, BindingResult result) {
		return "taxclaim";
	}
	@RequestMapping("/calculateTax")
	public String calculateTax( @ModelAttribute("userClaim") @Valid UserClaim userClaim, BindingResult result,ModelMap map) {
		
		if(result.hasErrors()) {
			
			return "taxclaim";
		}
		
		map.put("taxClaimAmount", taxService.calculateTax(userClaim));
		
		return "result";
	}

	
	@ModelAttribute("expenseList")
	public List<String> populateExpense() {
		
		List<String> list=new ArrayList<>();
		list.add("MedicalExpense");
		list.add("TravelExpense");
		list.add("FoodExpense");
		return list;
		
	}
}
