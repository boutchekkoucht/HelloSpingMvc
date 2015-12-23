package com.ensas.ecommerce.daos;

import com.ensas.ecommerce.entities.Client;

public interface IDaoClient {
	
	
	
	
	public void addClient(Client c);
	
	public Client getClient(int id);
	
	
	public void updateClient(Client c);
	
	
	public Client getClientByNameAndPasse(String email,String pass);
}
