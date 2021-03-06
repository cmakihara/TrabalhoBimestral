package br.casa.model;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.casa.principal.Produto;



public class ProdutoModel extends AbstractTableModel{

	private List<Produto> lista;
	private BigDecimal valor;
	
	public ProdutoModel(List<Produto> lista) {
		
		this.lista = lista;
		//this.valor = dolar;
		
	}

	@Override
	public int getColumnCount() {
		
		return 3;
	}

	@Override
	public int getRowCount() {
		
		return lista.size();
	}
	
	

	@Override
	public String getColumnName(int column) {
				
		switch (column) {
		case 0:
			return "Codigo";
		case 1:
			return "Descri��o";
		case 2:
			return "Valor ";
		
		}
		
		
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Produto p = this.lista.get(row);
		
		switch (column) {
		case 0:
			return p.getCodigo();
		case 1:
			return p.getDescricao();
		case 2:
			return "$\t"+p.getValorDolar();

		}
		
		return null;
	}

	public Produto getProduto(int idx) {
		
		return lista.get(idx);
		
	}


}
