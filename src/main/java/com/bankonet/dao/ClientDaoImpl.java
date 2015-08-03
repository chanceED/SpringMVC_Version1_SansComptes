package com.bankonet.dao;

import java.sql.ResultSet;
import java.util.List;























import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;

@Repository("dao")
@Scope("prototype")
@Transactional(propagation=Propagation.MANDATORY)//
public class ClientDaoImpl implements IClientDao{
	@PersistenceContext
 private EntityManager em;

	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void addClient(Client c) {
		em.persist(c);
		
		//throw new RuntimeException("Erreur runtime/checked!");
		
			try {
				throw new Exception("Erreur checked!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//System.out.println("dans ClientDaoImpl.addClient --> client ajouté !");	
	}

	@Override
	public List<Client> listClients() {
		Query query=em.createQuery("select c from Client c");
		return query.getResultList();
	}

	@Override
	public void deleteClient(int idClient) {
		Client c=em.find(Client.class, idClient);
		em.remove(c);
	//	System.out.println("dans ClientDaoImpl.deleteClient --> client supprimé !");	
		
	}

	@Override
	public Client editClient(int idClient) {
		Client c=em.find(Client.class, idClient);
		return c;
	}

	@Override
	public void updateClient(Client c) {
		em.merge(c);
		
	}

	@Override
	public List<Client> chercherClients(String motCle) {
		Query query=em.createQuery("select c from Client c where c.nom like :x or c.prenom like :x");
		query.setParameter("x","%"+motCle+"%");
		return query.getResultList();
	}
	
   

}
