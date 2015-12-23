package com.ensas.ecommerce.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ensas.ecommerce.entities.Client;

@Repository
public class DaoClient implements IDaoClient {

	
	 private static final Logger logger = LoggerFactory.getLogger(DaoClient.class);
	
		private SessionFactory sessionFactory;
		
		
		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		@Override
		public void addClient(Client c) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.getCurrentSession();
			session.persist(c);
		}

		@Override
		public Client getClient(int id) {
			// TODO Auto-generated method stub
			
			Session session=sessionFactory.getCurrentSession();
			Client c=(Client) session.load(Client.class,1);
			return c;
		}

		@Override
		public void updateClient(Client c) {
			
			Session session=sessionFactory.getCurrentSession();
			session.update(c);
			
		}

		@Override
		public Client getClientByNameAndPasse(String email, String pass) {
			
			Session session=sessionFactory.getCurrentSession();
			List<Client> li=session.createQuery("from Client").list();
			if(li==null)
				return null;
			return li.get(0);
		}

}
