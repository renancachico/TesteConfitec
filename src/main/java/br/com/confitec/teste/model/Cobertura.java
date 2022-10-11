package br.com.confitec.teste.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cobertura {
	
	private int cobertura;	
	private double valor;
}