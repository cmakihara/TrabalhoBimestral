package br.casa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.GridBagLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalBase extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalBase frame = new TelaPrincipalBase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalBase() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnCarregarLista = new JButton("Carregar lista");
		btnCarregarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarAbaLista();
				btnCarregarLista.setEnabled(false);
			}
		});
		panel.add(btnCarregarLista);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	
		
		GridBagConstraints gbc_btnCarregarLista = new GridBagConstraints();
		gbc_btnCarregarLista.insets = new Insets(0, 0, 0, 5);
		gbc_btnCarregarLista.gridx = 0;
		gbc_btnCarregarLista.gridy = 0;
		panel.add(btnCarregarLista, gbc_btnCarregarLista);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
		GridBagConstraints gbc_btnCadastrarCliente = new GridBagConstraints();
		gbc_btnCadastrarCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastrarCliente.gridx = 1;
		gbc_btnCadastrarCliente.gridy = 0;
		panel.add(btnCadastrarCliente, gbc_btnCadastrarCliente);
		
		JButton btnCriarOrcamento = new JButton("Criar orcamento");
		GridBagConstraints gbc_btnCriarOrcamento = new GridBagConstraints();
		gbc_btnCriarOrcamento.gridx = 2;
		gbc_btnCriarOrcamento.gridy = 0;
		panel.add(btnCriarOrcamento, gbc_btnCriarOrcamento);
		
		//JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	//	contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	protected void adicionarAbaLista() {
		JPanel painelLista = new PainelLista();
		
		PainelWrapper wrapper = new PainelWrapper();
		wrapper.setConteudo(painelLista);
		wrapper.setTitulo("Carregar lista");
		
	
		
		wrapper.setAcaoFechar(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.remove(wrapper);
			}
		});
		
		tabbedPane.addTab("Lista", wrapper);
		
	}
	

}