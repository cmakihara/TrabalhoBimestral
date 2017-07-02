package br.casa.telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PainelWrapper extends JPanel{
	
	private JButton btnFechar;
	private JLabel labelTitulo;

	/**
	 * Create the panel.
	 */
	public PainelWrapper() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		labelTitulo = new JLabel("New label");
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(labelTitulo, gbc_lblNewLabel);
		
		btnFechar = new JButton("Fechar aba");
		GridBagConstraints gbc_btnXis = new GridBagConstraints();
		gbc_btnXis.anchor = GridBagConstraints.EAST;
		gbc_btnXis.gridx = 1;
		gbc_btnXis.gridy = 0;
		panel.add(btnFechar, gbc_btnXis);

	}
	
	public void setConteudo(JPanel painel) {
		add(painel, BorderLayout.CENTER);
	}
	
	public void setAcaoFechar(ActionListener action) {
		btnFechar.addActionListener(action);
	}
	
	public void setTitulo(String titulo) {
		labelTitulo.setText(titulo);
	}
	

}
