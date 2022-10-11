# Teste Técnico CONFITEC

O valor pago por uma apólice de seguro é composto, basicamente, pela soma das coberturas contratadas. Com base nisso, elabore uma solução capaz de retornar o plano de pagamento de uma apólice de acordo com as opções solicitadas, aplicando ou não um percentual de juros no parcelamento. **A implementação desse teste deve ser disponibilizada em um repositório Git com acesso público.**

**Regras de negócio:**
- O resto da divisão do rateio é alocado na primeira parcela;
- A taxa de juros deverá ser aplicado ao valor total (soma das coberturas), utilizando a regra juros compostos:
**P = V*(1 + i)^t**, onde:
	**P** = Valor a ser pago;
	**V** = Valor total;
	**i** = Taxa de juros;
	**t** = Quantidade de parcelas;
- O parcelamento não se aplica para taxas de juros ou quantidade de parcelas negativas.

**Detalhes técnicos:**
- [Request JSON](https://pastecode.io/s/6unwc7j8)
- [Response JSON](https://pastecode.io/s/x291oae4)