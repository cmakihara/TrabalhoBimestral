package br.casa;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;



public class ClienteModel extends AbstractTableModel{
	
	private List<Cliente> lista;
	

	
	public ClienteModel(List<Cliente> _lista) {
		if (_lista == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = _lista;
		}
	}

	public ClienteModel(Cliente c) {
		this.lista = new ArrayList<>();
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
		
		switch(column){
		case 0:
			return "Nome";
		case 1:
			return "Telefone";
		case 2:
			return "CPF";
		
		}		
		return super.getColumnName(column);
	}

	@Override
	public Object getValueAt(int row, int column) {
		Cliente c = this.lista.get(row);
		
		switch(column){
		case 0:
			return c.getNome();
		case 1:
			return c.getTelefone();
		case 2:
			return c.getCpf();
		
		}
		throw new RuntimeException("Coluna " + column +
				" solicitada, não existe.");
	}

	public void adicionar(Cliente c) {
		this.lista.add(c);
		super.fireTableDataChanged();
		
	}

	public Cliente getCliente(int idx) {
		return lista.get(idx);
	}

}
