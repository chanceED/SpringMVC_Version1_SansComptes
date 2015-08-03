package com.bankonet.spring;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;

@Controller
public class BankonetController {
	
	/**
	 * 
	 */
	@Autowired
	private IBankonetMetier metier;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model){
	model.addAttribute("client", new Client());
	model.addAttribute("clients", metier.listClients());
	System.out.println( metier.listClients());
	return "clientsview";
	}
	

	
	@RequestMapping(value="/saveClient",method = RequestMethod.POST)
	public String saveClient(@Valid Client client, BindingResult bindingResult, Model  model) throws Exception {
		
	
		if(bindingResult.hasErrors()) {
		model.addAttribute("clients",  metier.listClients());
		return  "clientsview"; 
	}
		if(client.getId()==0) {//pour faire la différence avec le éditer
			metier.addClient(client);
			model.addAttribute("msg", "Le client n°"+client.getId()+" a bien été ajouté");
		}
		
		else {
		metier.updateClient(client);
		model.addAttribute("msg", "Le client n°"+client.getId()+" a bien été mis à jour");
		}
		
		model.addAttribute("client", new Client());
		model.addAttribute("clients", metier.listClients());
		return "clientsview";
	}
	
	
	@RequestMapping(value="/deleteClient")
	public  String  delete(@RequestParam(value="id") int  id,  Model  model) { 
		metier.deleteClient(id);
		model.addAttribute("client",  new  Client());
		model.addAttribute("clients",  metier.listClients());
		model.addAttribute("msg", "Le client n°"+id+" a bien été supprimé");
		return "clientsview";
	}
	
	@RequestMapping(value="/editClient/{id}")
	public  String	edit(@PathVariable(value="id") int id,  Model	model) {
		Client c = metier.editClient(id);
		model.addAttribute("client",c);
		model.addAttribute("clients", metier.listClients());
		return  "clientsview";
	}
	
	/*if(client.getId()==0){metier.addClient(client);
	}else{
		metier.editClient(client.getId());
	}
	metier.addClient(client);
	model.addAttribute("client", new Client());
	model.addAttribute("clients", metier.listClients());
	return "clientsview";
	}*/
	
/*	
	@RequestMapping(value = "/deleteClient", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id, Model model) {
		
		metier.deleteClient(id);
		// permet de garder l'affichage de la bdd sur la page
		model.addAttribute("listeClients",  metier.listClients());
		model.addAttribute("client",new Client());
		return  "clientsview";
	}
	
	@RequestMapping(value = "/editClient", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, Model model) {
		
		// permet de garder l'affichage de la bdd sur la page
		model.addAttribute("listeClients",  metier.listClients());
		// rempli le formulaire avec le client à editer
		model.addAttribute("client",metier.editClient(id));
		return  "clientsview";
	}
*/
	
	

	/*@RequestMapping(value="/suppClient")
	public String suppClient(int idClient,Model model){
	metier.deleteClient(idClient);
	model.addAttribute("client", new Client());
	model.addAttribute("clients", metier.listClients());
	return "clientsview";
	}
	
	@RequestMapping(value="/editClient")
	public String editClient(int idClient,Model model){
	Client c=metier.editClient(idClient);
	
	model.addAttribute("editedClient", c);
	model.addAttribute("client",c );
	model.addAttribute("clients", metier.listClients());
	return "clients";
	} 
	
	*/
}
