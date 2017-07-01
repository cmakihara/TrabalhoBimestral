package br.casa;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelLista extends JPanel {
	private JTable table;
	private ProdutoModel modelo;
	List<Produto> lista;

	/**
	 * Create the panel.
	 */
	public PainelLista() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnCarregarLista = new JButton("Baixar lista");
		btnCarregarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carregar();
				
			}
		});
		GridBagConstraints gbc_btnCarregarLista = new GridBagConstraints();
		gbc_btnCarregarLista.insets = new Insets(0, 0, 5, 5);
		gbc_btnCarregarLista.gridx = 0;
		gbc_btnCarregarLista.gridy = 0;
		add(btnCarregarLista, gbc_btnCarregarLista);
		
		JButton btnAdicionarListaAo = new JButton("Adicionar lista ao banco");
		btnAdicionarListaAo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarBanco();
				btnAdicionarListaAo.setEnabled(false);
			//	btnAdicionarListaAo.setName("Lista ja adicionada ao banco");
				
			}
		});
		GridBagConstraints gbc_btnAdicionarListaAo = new GridBagConstraints();
		gbc_btnAdicionarListaAo.anchor = GridBagConstraints.WEST;
		gbc_btnAdicionarListaAo.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarListaAo.gridx = 1;
		gbc_btnAdicionarListaAo.gridy = 0;
		add(btnAdicionarListaAo, gbc_btnAdicionarListaAo);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	protected void adicionarBanco() {
		
		try {
			LeitorProdutoUrl url = new LeitorProdutoUrl();
			lista = url.lerProdutos("http://www.master10.com.py/lista-txt/download");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		for(int i =1; i<lista.size();i++){
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO produto(codigo,descricao,valor) VALUES(");			
			sb.append(lista.get(i).getCodigo());
			sb.append(",'");
			sb.append(lista.get(i).getDescricao());
			sb.append("',");
			sb.append(lista.get(i).getValorDolar());
			sb.append(")");
			sb.append(";");
			//System.out.println(sb.toString());
			
			Connection con = ConexaoDB.getInstance().getConnection();
			try {
				PreparedStatement ps = con.prepareStatement(sb.toString());
				ps.executeQuery();
			} catch (SQLException e) {
			}
		}
				
	}

	protected void carregar() {
		String url = "http://www.master10.com.py/lista-txt/download";
		LeitorProdutoUrl lpu = new LeitorProdutoUrl();
		try {
				
			List<Produto> lista;
			lista = lpu.lerProdutos(url);			
			//String strDolar = txfDolar.getText().trim();
			//BigDecimal dolar= new BigDecimal (strDolar);
			modelo = new ProdutoModel(lista);
			table.setModel(modelo);
				
				
		} catch (Exception e1) {
				
			e1.printStackTrace();
		}
		
	}

}
