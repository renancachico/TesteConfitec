package br.com.confitec.teste.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.confitec.teste.model.Cobertura;
import br.com.confitec.teste.model.Dados;
import br.com.confitec.teste.model.OpcaoParcelamento;
import br.com.confitec.teste.model.Parcelamento;

@Service
public class ParcelamentoService {

	public List<Dados> calcularParcelamentos(Parcelamento parcelamento) {		
		List<Dados> dados = new ArrayList<>();
		double valorTotal = recuperaValorTotalCoberturas(parcelamento.getListCobertura());
		int parcela = 0;
		
		for(OpcaoParcelamento opcaoParcelamento : parcelamento.getListOpcaoParcelamento()) {
			int totalparcelas = recuperaParcelas(opcaoParcelamento.getQuantidadeMinimaParcelas(), opcaoParcelamento.getQuantidadeMaximaParcelas());
			
			for(int i = 0; i < totalparcelas; i++) {
				parcela++;
				double valorSerPago = calcularJuros(opcaoParcelamento.getJuros(), parcela, valorTotal);
				double valorPrimeiraParcela = valorSerPago / parcela;
				double valorParcelamentoTotal = valorSerPago / parcela;			
				
				Dados dado = new Dados();
				dado.setQuantidadeParcelas(parcela);
				dado.setValorPrimeiraParcela(Math.round(valorPrimeiraParcela * 100) / 100.0d);
				dado.setValorDemaisParcelas(Math.round(valorParcelamentoTotal * 100) / 100.0d);
				dado.setValorParcelamentoTotal(Math.round(valorSerPago * 100) / 100.0d);
				dados.add(dado);
			}
		}

		return dados;
	}
	
	public double recuperaValorTotalCoberturas(List<Cobertura> listCobertura) {
		double valorTotalCoberturas = listCobertura.stream().map(Cobertura::getValor).mapToDouble(Double::doubleValue).sum();
		return valorTotalCoberturas;
	}
	
	public int recuperaParcelas(int quantidadeMinimaParcelas, int quantidadeMaximaParcelas) {
		int totalparcelas = 0;
		int valor = quantidadeMaximaParcelas - quantidadeMinimaParcelas + 1;
		totalparcelas += valor;
		return totalparcelas;
	}
	
	public double calcularJuros(double taxa, int parcela, double valorTotal) {
		double resultado = valorTotal * Math.pow((1 + taxa), parcela);
        return resultado;
    }
}