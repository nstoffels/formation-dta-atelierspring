package com.bankonet.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bankonet.metier.IBankonetMetier;
import com.bankonet.model.Client;



@Controller
@RequestMapping(value="/rest")
public class BankonetRestController {

	@Autowired
	private IBankonetMetier bankonetMetier;

	public BankonetRestController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param motCle
	 * @return
	 */
	@RequestMapping(value="/listeclient/{motCle}", method = RequestMethod.GET)
	@ResponseBody
	public List<Client> chercherClient(@PathVariable("motCle") String motCle){


		return bankonetMetier.chercherClients(motCle);

	}

	/**
	 * 
	 * @param c
	 */
	@RequestMapping(value="/ajoutclient", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public void ajoutClient(@RequestBody Client c){

		bankonetMetier.addClient(c);
	}

	/**
	 * 
	 * @param id
	 */
	@RequestMapping(value = "/supprimerclient/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable("id") int id) {
		bankonetMetier.deleteClient(id);
	}

}
