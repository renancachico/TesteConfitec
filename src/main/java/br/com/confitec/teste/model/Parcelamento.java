package br.com.confitec.teste.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parcelamento {
	
	private List<Cobertura> listCobertura;
	private List<OpcaoParcelamento> listOpcaoParcelamento;
}