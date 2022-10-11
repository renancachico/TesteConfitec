package br.com.confitec.teste.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpcaoParcelamento {
	
	private int quantidadeMinimaParcelas;	
	private int quantidadeMaximaParcelas;	
	private double juros;
}