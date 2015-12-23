package com.ensas.ecommerce.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ensas.ecommerce.daos.IDaoClient;
import com.ensas.ecommerce.entities.Client;

@Service
public class  ServiceClient implements IServiceClient{
	
	private IDaoClient dao;

	

	@Override
	@Transactional
	public boolean isPossible(int id, double solde) {
		if(dao.getClient(id).getSolde()>=solde)
		return true;
		
		return false;
	}
	
	

	@Override
	@Transactional
	public void retirer(int  id, double solde) {
		Client c= dao.getClient(id);
		c.setSolde(solde);
		dao.updateClient(c);
	}

	@Override
	public boolean login(String email, String pass) {
		
		if(dao.getClientByNameAndPasse(email, pass)==null)
		return false;
		
		return true;
	}



	public IDaoClient getDao() {
		return dao;
	}



	public void setDao(IDaoClient dao) {
		this.dao = dao;
	}

	
	
	

	
	

}
