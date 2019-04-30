package br.com.fiap.trabalhofinal.model;

import com.wordnik.swagger.annotations.ApiModelProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {

	@ApiModelProperty(notes = "Timestamp da transação no momento do cadastro")
	private long timestamp;

	@ApiModelProperty(notes = "Valor da transação")
	private double amount;

}
