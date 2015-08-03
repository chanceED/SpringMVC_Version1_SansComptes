package com.bankonet.metier;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;
import com.bankonet.dao.*;


@Transactional
@Service("bankonetMetier")//le nom de mon service metier pour l'injection par annotation
public class BankonetMetier implements IBankonetMetier {
 
	@Resource(name="dao")
	private IClientDao dao;
	
	public BankonetMetier() {
		super();
	}


	@Transactional(rollbackFor=Exception.class)// le rollback pour annuler la transaction
	public void addClient(Client c) throws Exception {
		 dao.addClient(c);
		
	}
    
	@Transactional(readOnly=true)
	@Override
	public List<Client> listClients() {
		return dao.listClients();
	
	}
     @Transactional
	@Override
	public void deleteClient(int idClient) {
		dao.deleteClient(idClient);
		
	}
    @Transactional
	@Override
	public Client editClient(int idClient) {
		return dao.editClient(idClient);
	}

    @Transactional
	@Override
	public void updateClient(Client c) {
		dao.updateClient(c);
		
	}
    
	@Transactional(readOnly=true)
	@Override
	public List<Client> chercherClients(String motCle) {
		return dao.chercherClients(motCle);
	}

	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

	@Transactional
	public List<Client> SupprimerClientDontLeNomContient(String motCle) {
		
		for(Client c:dao.chercherClients(motCle)){
			dao.deleteClient(c.getId());
		}
		return dao.listClients();
	}
	
	
	
}
