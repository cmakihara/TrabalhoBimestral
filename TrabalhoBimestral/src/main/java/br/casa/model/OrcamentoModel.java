package br.casa.model;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.casa.principal.Produto;

public class OrcamentoModel extends AbstractTableModel {

	private List<Produto> listaP;
	private BigDecimal valor;
	
	public OrcamentoModel(List<Produto> listaP) {
		
		this.listaP = listaP;
				
	}

	@Override
	public int getColumnCount() {
		
		return 5;
	}

	@Override
	public int getRowCount() {
		
		return listaP.size();
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
		case 3 :
			return "Quantidade";
		case 4 :
			return "Valor total do produto";
		}
		
		
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Produto p = this.listaP.get(row);
		int strTotalP = p.getQuantidade();
		BigDecimal totalP= new BigDecimal (strTotalP);
		
		switch (column) {
		case 0:
			return p.getCodigo();
		case 1:
			return p.getDescricao();
		case 2:
			return "$\t"+p.getValorDolar();
		case 3:
			return p.getQuantidade();
		case 4:
			return p.getValorDolar().multiply(totalP);
		}
		
		return null;
	}

	public Produto getProduto(int idx) {
		
		return listaP.get(idx);
	}

}
