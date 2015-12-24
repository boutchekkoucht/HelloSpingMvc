package com.ensas.ecommerce.daos;

import java.beans.Expression;
import java.util.List;








import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
			Criteria cri= session.createCriteria(Client.class);
			cri.add(Restrictions.eq("email", email));
			cri.add(Restrictions.eq("motpasse", pass));
			
			List<Client> li=cri.list();
			if(li.size()==0){
				
				return null;
			}
			System.out.println("++"+li.get(0).getId()+"////");
			return li.get(0);
		}

}
