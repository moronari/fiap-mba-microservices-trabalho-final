package br.com.fiap.trabalhofinal.repository;

import java.util.ArrayList;
import java.util.stream.Collectors;

import br.com.fiap.trabalhofinal.model.Statistic;
import br.com.fiap.trabalhofinal.model.Transaction;

public class ApiRepository {

	private ArrayList<Transaction> transactions = new ArrayList<>();

	public boolean save(Transaction transaction) {
		// Verifica se a transação foi gerada há mais de 60 segundos
		if (System.currentTimeMillis() - transaction.getTimestamp() <= 60000) {
			transactions.add(transaction);
			return true;
		}

		return false;
	}

	public Statistic all() {

		Statistic statistic = new Statistic();
		// Filtra todas as transações dos ultimos 60 segundos
		ArrayList<Transaction> filterTransactions = (ArrayList<Transaction>) transactions.stream()
				.filter(t -> System.currentTimeMillis() - t.getTimestamp() <= 60000).collect(Collectors.toList());

		double avg = filterTransactions.stream().mapToDouble(Transaction::getAmount).average().getAsDouble();
		double sum = filterTransactions.stream().mapToDouble(Transaction::getAmount).sum();
		double max = filterTransactions.stream().mapToDouble(Transaction::getAmount).max().getAsDouble();
		double min = filterTransactions.stream().mapToDouble(Transaction::getAmount).min().getAsDouble();
		long count = filterTransactions.stream().mapToDouble(Transaction::getAmount).count();

		statistic.setAvg(avg);
		statistic.setSum(sum);
		statistic.setMax(max);
		statistic.setMin(min);
		statistic.setCount(count);

		return statistic;
	}
}
