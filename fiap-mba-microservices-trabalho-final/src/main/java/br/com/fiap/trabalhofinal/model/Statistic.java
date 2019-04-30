package br.com.fiap.trabalhofinal.model;

import com.wordnik.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Statistic {

	@ApiModelProperty(notes = "Somatório dos valores das transações cadastradas")
	private double sum = 0.0;

	@ApiModelProperty(notes = "Menor valor cadastrado")
	private double min = 0.0;

	@ApiModelProperty(notes = "Maior valor cadastrado")
	private double max = 0.0;

	@ApiModelProperty(notes = "Média dos valores das transações cadastradas")
	private double avg = 0.0;

	@ApiModelProperty(notes = "Total de transações")
	private long count = 0;
}
