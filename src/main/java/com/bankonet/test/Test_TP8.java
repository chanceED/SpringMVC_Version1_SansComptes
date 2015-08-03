package com.bankonet.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bankonet.dao.ClientDaoImpl;
import com.bankonet.dao.IClientDao;
import com.bankonet.metier.BankonetMetier;
import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Adresse;
import com.bankonet.model.Client;



public class Test_TP8 {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		
		
		 /*Test sans annotaions*/
		/*BankonetMetier metier=(BankonetMetier) ac.getBean("metier");  //correspond à l'id du bean metier dans le beans.xml (<bean  id="metier" class="com.bankonet.metier.BankonetMetier">)
		Client client=new Client(1,"Clarisse",vincent");
		metier.addClient(client);*/
		
		 //Test avec les annotations
	//	dans  mon BankonetMetier,j'ai l'annotation @Service("bankonetMetier"),c'est ça qu'on met dans ac.getBean(xx) ici
		IBankonetMetier metier=(IBankonetMetier) ac.getBean("bankonetMetier");
	//	Client client=new Client(1,"eric","marc");
	//	Adresse adresse1=new Adresse(36,"avenue carnot","Paris");
		
	//ClientDaoImpl  id=new ClientDaoImpl();
	//id.addClient(c);
		
		metier.addClient(new Client("system","Martin","dfdfds","mdp2HYHY",new Adresse(36,"avenue carnot","Paris")));
		System.out.println(metier.listClients());
			
	    
	}

}
