package com.bankonet.metier;

import java.util.List;

import com.bankonet.model.Client;
import com.bankonet.model.Compte;
import com.bankonet.model.CompteCourant;

public interface IBankonetMetier {
	
	public void addClient(Client c) throws Exception;

	public List<Client> listClients(); 

	public void deleteClient(int idClient); 

	public Client editClient(int idClient); 

	public void updateClient(Client c);

	public List<Client> chercherClients(String motCle);
	
	

	

}
