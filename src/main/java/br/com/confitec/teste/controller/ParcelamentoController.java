package br.com.confitec.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confitec.teste.model.Dados;
import br.com.confitec.teste.model.Parcelamento;
import br.com.confitec.teste.service.ParcelamentoService;

@RestController
@RequestMapping("/confitec/teste/parcelamento")
public class ParcelamentoController {

	@Autowired
	private ParcelamentoService parcelamentoService;

	@PostMapping
	public ResponseEntity<List<Dados>> calcularParcelamentos(@RequestBody Parcelamento parcelamento) {
		if((parcelamento.getListCobertura() == null || parcelamento.getListCobertura().isEmpty())
				|| (parcelamento.getListOpcaoParcelamento() == null
						|| parcelamento.getListOpcaoParcelamento().isEmpty())) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(parcelamentoService.calcularParcelamentos(parcelamento));
	}
}