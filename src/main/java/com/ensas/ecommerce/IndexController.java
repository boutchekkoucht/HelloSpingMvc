package com.ensas.ecommerce;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ensas.ecommerce.services.IServiceClient;


/**
 * Handles requests for the application home page.
 */
@Controller
@RestController
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> login(@RequestParam  String email,@RequestParam  String pass) {
		
   	 	
		if(iServiceClient.login(email, pass))
		 return new ResponseEntity<String>(HttpStatus.OK);
		
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
	
	
	@RequestMapping(value = "/ispossible", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> ispossible(@RequestParam  int id,@RequestParam  double solde) {
		
   	 	
		if(iServiceClient.isPossible(id, solde))
		 return new ResponseEntity<String>(HttpStatus.OK);
		
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
	
	
	@RequestMapping(value = "/retirer", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> retirer(@RequestParam  int id,@RequestParam  double solde) {
		
   	 	
		if(iServiceClient.isPossible(id, solde))
		{
		  iServiceClient.retirer(id, solde);
		 return new ResponseEntity<String>(HttpStatus.OK);
		}
		
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
 
	
}
