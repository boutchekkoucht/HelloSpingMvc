package com.ensas.ecommerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensas.ecommerce.services.IServiceClient;


/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	
	IServiceClient iServiceClient;
	
	@Autowired(required=true)
	 @Qualifier(value="iServiceClient")	
	public void setIServiceClient(IServiceClient s){
		iServiceClient=s;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		System.out.println(""+iServiceClient.isPossible(1, 10050));

		
		return "home";
	}
	
}
