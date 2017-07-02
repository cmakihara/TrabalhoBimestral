package br.casa;

import java.math.BigDecimal;

public class Produto {

	private Long codigo;
	private String descricao;
	private BigDecimal valorDolar;
	private BigDecimal dolar;
	private int quantidade;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValorDolar() {
		return valorDolar;
	}
	public void setValorDolar(BigDecimal valorDolar) {
		this.valorDolar = valorDolar;
	}
	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", valorDolar=" + valorDolar + "]";
	}
	public BigDecimal getDolar() {
		return dolar;
	}
	public void setDolar(BigDecimal dolar) {
		this.dolar = dolar;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
