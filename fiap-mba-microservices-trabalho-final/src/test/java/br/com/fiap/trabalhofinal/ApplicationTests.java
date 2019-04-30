package br.com.fiap.trabalhofinal;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.trabalhofinal.controller.ApiController;
import br.com.fiap.trabalhofinal.model.Transaction;
import br.com.fiap.trabalhofinal.repository.ApiRepository;

@RunWith(SpringRunner.class)
@WebMvcTest({ ApiController.class, ApiRepository.class })
public class ApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void transactions() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		Transaction transaction = new Transaction(System.currentTimeMillis(), 1000.00);

		mvc.perform(MockMvcRequestBuilders.post("/transactions").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(transaction))).andExpect(MockMvcResultMatchers.status().isCreated());
	
	}

	@Test
	public void statistics() throws Exception {

		mvc.perform(MockMvcRequestBuilders.get("/statistics")).andExpect(MockMvcResultMatchers.status().isOk());

	}

}
