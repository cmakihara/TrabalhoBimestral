package br.casa;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;



public class ProdutoModel extends AbstractTableModel{

	private List<Produto> lista;
	private BigDecimal valor;
	
	ProdutoModel(List<Produto> lista) {
		
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
			return "Descrição";
		case 2:
			return "Valor ";
		//case 3 :
		//	return "Valor em real";
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
			return p.getValorDolar();
	//	case 3:
	//		return p.getValorDolar().multiply(valor);
		}
		
		return null;
	}

	public Produto getProduto(int idx) {
		
		return lista.get(idx);
	}


}
