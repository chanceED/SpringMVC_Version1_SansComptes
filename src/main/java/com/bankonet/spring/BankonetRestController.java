package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
@RequestMapping(value="/rest")
public class BankonetRestController {
	
	@Autowired
	private IBankonetMetier metier;
     
	
	@RequestMapping(value ="listeClients/{motCle}", method = RequestMethod.GET)//requete envoyée par le client REST,ici c'est postman,lui meme détermine le type de reponse voulue,xml OU JSON
	@ResponseBody  //reponse que nous lui renvoyons,en fonction du type de repoonse de client,les données sont automatiquement converties en ce type
	public List<Client> listeClients(@PathVariable("motCle") String motCle){

		return metier.chercherClients(motCle);
	}
	
	
	@RequestMapping(value ="ajouterClient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void ajouterClient(@RequestBody Client c) throws Exception {
		 metier.addClient(c);
	}

	
	@RequestMapping(value ="SupprimerClient/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
		public void supprimerClient(@PathVariable("id") int id){
		 metier.deleteClient(id);
	}
	
		
	
}
