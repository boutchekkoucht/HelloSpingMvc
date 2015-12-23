package com.ensas.ecommerce.services;

import com.ensas.ecommerce.entities.Client;

public interface IServiceClient {
	

	public boolean  isPossible(int id,double solde);
	public void retirer(int id,double solde);
	public boolean login(String email,String pass);

}
