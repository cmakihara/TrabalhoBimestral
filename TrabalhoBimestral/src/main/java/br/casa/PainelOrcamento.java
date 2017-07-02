package br.casa;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelOrcamento extends JPanel {
	private JTextField txfBusca;
	protected JTextField txtBnome;
	private JTextField txfBtelefone;
	private JTextField txfBcpf;
	private JTable table;
	private JTextField textField_1;
	private JTextField txfBcodigo;
	private JTextField txfBdescricao;
	private JTextField txfBvalor;
	private JTextField txfQuantidade;
	private ClienteModel modelo;
	private Cliente clienteSelecionado;
	private ProdutoModel modelo2;
	private Produto produtoSelecionado;

	/**
	 * Create the panel.
	 */
	public PainelOrcamento() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblBuscaClientef = new JLabel("Busca cliente (F2)");
		GridBagConstraints gbc_lblBuscaClientef = new GridBagConstraints();
		gbc_lblBuscaClientef.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscaClientef.anchor = GridBagConstraints.EAST;
		gbc_lblBuscaClientef.gridx = 0;
		gbc_lblBuscaClientef.gridy = 0;
		panel.add(lblBuscaClientef, gbc_lblBuscaClientef);
		
		txfBusca = new JTextField();
		txfBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_F2){
					abreBusca();
				}
				
			}
			
		});
		GridBagConstraints gbc_txfBusca = new GridBagConstraints();
		gbc_txfBusca.anchor = GridBagConstraints.WEST;
		gbc_txfBusca.insets = new Insets(0, 0, 5, 5);
		gbc_txfBusca.gridx = 1;
		gbc_txfBusca.gridy = 0;
		panel.add(txfBusca, gbc_txfBusca);
		txfBusca.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);
		
		JLabel lblTelefone = new JLabel("Telefone");
		GridBagConstraints gbc_lblTelefone = new GridBagConstraints();
		gbc_lblTelefone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefone.gridx = 1;
		gbc_lblTelefone.gridy = 1;
		panel.add(lblTelefone, gbc_lblTelefone);
		
		JLabel lblCpf = new JLabel("CPF");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.insets = new Insets(0, 0, 5, 0);
		gbc_lblCpf.gridx = 2;
		gbc_lblCpf.gridy = 1;
		panel.add(lblCpf, gbc_lblCpf);
		
		txtBnome = new JTextField();
		GridBagConstraints gbc_txtBnome = new GridBagConstraints();
		gbc_txtBnome.insets = new Insets(0, 0, 0, 5);
		gbc_txtBnome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBnome.gridx = 0;
		gbc_txtBnome.gridy = 2;
		panel.add(txtBnome, gbc_txtBnome);
		txtBnome.setColumns(10);
		
		txfBtelefone = new JTextField();
		GridBagConstraints gbc_txfBtelefone = new GridBagConstraints();
		gbc_txfBtelefone.insets = new Insets(0, 0, 0, 5);
		gbc_txfBtelefone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBtelefone.gridx = 1;
		gbc_txfBtelefone.gridy = 2;
		panel.add(txfBtelefone, gbc_txfBtelefone);
		txfBtelefone.setColumns(10);
		
		txfBcpf = new JTextField();
		GridBagConstraints gbc_txfBcpf = new GridBagConstraints();
		gbc_txfBcpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBcpf.gridx = 2;
		gbc_txfBcpf.gridy = 2;
		panel.add(txfBcpf, gbc_txfBcpf);
		txfBcpf.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(112, 128, 144));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblBuscaProdutof = new JLabel("Busca produto(F2)");		
		GridBagConstraints gbc_lblBuscaProdutof = new GridBagConstraints();
		gbc_lblBuscaProdutof.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuscaProdutof.anchor = GridBagConstraints.EAST;
		gbc_lblBuscaProdutof.gridx = 0;
		gbc_lblBuscaProdutof.gridy = 0;
		panel_2.add(lblBuscaProdutof, gbc_lblBuscaProdutof);
		
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_F2){
					abreBuscaProduto();
				}
			}
			
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 0;
		panel_2.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JButton btnAdicionarAoCarrinho = new JButton("Adicionar ao carrinho");
		btnAdicionarAoCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarCarrinho();
			}
		});
		GridBagConstraints gbc_btnAdicionarAoCarrinho = new GridBagConstraints();
		gbc_btnAdicionarAoCarrinho.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionarAoCarrinho.gridx = 3;
		gbc_btnAdicionarAoCarrinho.gridy = 0;
		panel_2.add(btnAdicionarAoCarrinho, gbc_btnAdicionarAoCarrinho);
		
		JLabel lblCodigo = new JLabel("Codigo");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 1;
		panel_2.add(lblCodigo, gbc_lblCodigo);
		
		JLabel lblDescricao = new JLabel("Descricao");
		GridBagConstraints gbc_lblDescricao = new GridBagConstraints();
		gbc_lblDescricao.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescricao.gridx = 1;
		gbc_lblDescricao.gridy = 1;
		panel_2.add(lblDescricao, gbc_lblDescricao);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBackground(new Color(105, 105, 105));
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 2;
		gbc_lblValor.gridy = 1;
		panel_2.add(lblValor, gbc_lblValor);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		GridBagConstraints gbc_lblQuantidade = new GridBagConstraints();
		gbc_lblQuantidade.insets = new Insets(0, 0, 5, 0);
		gbc_lblQuantidade.gridx = 3;
		gbc_lblQuantidade.gridy = 1;
		panel_2.add(lblQuantidade, gbc_lblQuantidade);
		
		txfBcodigo = new JTextField();
		GridBagConstraints gbc_txfBcodigo = new GridBagConstraints();
		gbc_txfBcodigo.insets = new Insets(0, 0, 0, 5);
		gbc_txfBcodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBcodigo.gridx = 0;
		gbc_txfBcodigo.gridy = 2;
		panel_2.add(txfBcodigo, gbc_txfBcodigo);
		txfBcodigo.setColumns(10);
		
		txfBdescricao = new JTextField();
		GridBagConstraints gbc_txfBdescricao = new GridBagConstraints();
		gbc_txfBdescricao.insets = new Insets(0, 0, 0, 5);
		gbc_txfBdescricao.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBdescricao.gridx = 1;
		gbc_txfBdescricao.gridy = 2;
		panel_2.add(txfBdescricao, gbc_txfBdescricao);
		txfBdescricao.setColumns(10);
		
		txfBvalor = new JTextField();
		GridBagConstraints gbc_txfBvalor = new GridBagConstraints();
		gbc_txfBvalor.insets = new Insets(0, 0, 0, 5);
		gbc_txfBvalor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfBvalor.gridx = 2;
		gbc_txfBvalor.gridy = 2;
		panel_2.add(txfBvalor, gbc_txfBvalor);
		txfBvalor.setColumns(10);
		
		txfQuantidade = new JTextField();
		GridBagConstraints gbc_txfQuantidade = new GridBagConstraints();
		gbc_txfQuantidade.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfQuantidade.gridx = 3;
		gbc_txfQuantidade.gridy = 2;
		panel_2.add(txfQuantidade, gbc_txfQuantidade);
		txfQuantidade.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	protected void adicionarCarrinho() {
		
		ProdutoDao produtoDao = new ProdutoDao();
		
		Produto p = new Produto();
		p.setCodigo(Long.parseLong(txfBcodigo.getText()));
		p.setDescricao(txfBdescricao.getText().trim());
		p.setValorDolar(new BigDecimal(txfBvalor.getText()));
		p.setQuantidade(Integer.parseInt(txfQuantidade.getText()));
			
				
		produtoDao.inserir(p);	
		
	}

	protected void abreBuscaProduto() {
		ProdutoDao dao = new ProdutoDao();
		List<Produto> lista = dao.getTodos();
		
		this.modelo2 = new ProdutoModel(lista);
	
		table.setModel(modelo2);
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int idx = table.getSelectedRow();
					if (idx < 0) {
						System.out.println("Não há linha selecionada");
					} else {
						System.out.println("Linha " + idx);
						carregarLinhaProduto(idx);
					}
				}
			}
		});
		
	}

	protected void carregarLinhaProduto(int idx) {
		Produto p = this.modelo2.getProduto(idx);
		this.produtoSelecionado = p;		
		txfBcodigo.setText(String.valueOf(p.getCodigo()));	
		txfBdescricao.setText(p.getDescricao());
		txfBvalor.setText(String.valueOf(p.getValorDolar()));
		txfQuantidade.setText("1");
		
	}

	protected void abreBusca() {

		ClienteDao dao = new ClienteDao();
		List<Cliente> lista = dao.getTodos();
		
		this.modelo = new ClienteModel(lista);
		// this.modelo = new ContatoModel();
		table.setModel(modelo);
		
		table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int idx = table.getSelectedRow();
					if (idx < 0) {
						System.out.println("Não há linha selecionada");
					} else {
						System.out.println("Linha " + idx);
						carregarLinha(idx);
					}
				}
			}
		});
	
		
	}

	protected void carregarLinha(int idx) {
		Cliente c = this.modelo.getCliente(idx);
		this.clienteSelecionado = c;		
		txtBnome.setText(c.getNome());;
		txfBtelefone.setText(c.getTelefone());
		txfBcpf.setText(c.getCpf());	
	//	table.setModel(new TableModel() {   mudar para apagar table
			
			
	}
	

	
}
