package br.com.fiap.trabalhofinal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.fiap.trabalhofinal.model.Statistic;
import br.com.fiap.trabalhofinal.model.Transaction;
import br.com.fiap.trabalhofinal.repository.ApiRepository;

@RestController
@Api(value = "Statistic", description = "Statistic RestAPI")

public class ApiController {

	private static ApiRepository repository = new ApiRepository();

	@GetMapping("/statistics")
	@ApiOperation(httpMethod = "GET", value = "Chamada metodo GET: Calcula estatisticas dos dados inputados (transactions)")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Estatística das transações cadastradas.", response = Statistic.class) })
	public ResponseEntity<Statistic> statistic() throws Exception {

		return new ResponseEntity<>(repository.all(), HttpStatus.OK);

	}

	@PostMapping("/transactions")
	@ApiOperation(httpMethod = "POST", value = "Chamada metodo POST: Inclui transações contendo timestamp e valor")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Transação inserida"),
			@ApiResponse(code = 204, message = "Erro ao inserir transação. Transação ocorreu há mais de 60 segundos"), })
	public ResponseEntity<Transaction> transaction(@RequestBody Transaction transaction) throws Exception {

		return new ResponseEntity<Transaction>(
				repository.save(transaction) ? HttpStatus.CREATED : HttpStatus.NO_CONTENT);

	}
}
