package br.com.confitec.teste.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dados {

	private int quantidadeParcelas;
	private double valorPrimeiraParcela;
	private double valorDemaisParcelas;
	private double valorParcelamentoTotal;
}