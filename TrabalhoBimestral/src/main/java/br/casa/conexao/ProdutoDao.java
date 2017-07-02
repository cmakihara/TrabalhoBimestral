package br.casa.conexao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.casa.principal.Produto;
import br.casa.telas.PainelOrcamento;

public class ProdutoDao {	
	
	private static final String SQL_SELECTALL = "select * from produto;";
	private static final String SQL_SELECT = "select * from produto where descricao ILIKE a%;";
	private static final String SQL_SELECTORC = "select * from orcamento1;";
	private static final String SQL_INSERT = "insert into orcamento1(codigo, descricao,valor_unidade,quantidade,valor_total_produto)values(?, ?, ?, ?,?)";
	private static final String SQL_DELETE = "delete from produto where id = ?;";
	private Connection con;

	public ProdutoDao() {
		
		ConexaoDB conexao = ConexaoDB.getInstance();
		con = conexao.getConnection();
	}


	public void inserir(Produto p) {
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setLong(1, p.getCodigo());
			ps.setString(2, p.getDescricao());
			ps.setBigDecimal(3, p.getValorDolar());
			ps.setInt(4, p.getQuantidade());
			int strTotalP = p.getQuantidade();
			BigDecimal totalP= new BigDecimal (strTotalP);
			ps.setBigDecimal(5, p.getValorDolar().multiply(totalP));
			
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Produto> getTodos() {		
		
		List<Produto> lista = new ArrayList<>();		
		
		try (PreparedStatement ps = con	.prepareStatement(SQL_SELECTALL);					
			ResultSet rs = ps.executeQuery()) {			
			
			while (rs.next()) {
				Produto p = new Produto();				
				p.setCodigo(rs.getLong(2));
				p.setDescricao(rs.getString(3));
				p.setValorDolar(rs.getBigDecimal(4));
				lista.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
		
		
	}
//	public List<Produto> getTodoss(JTextField text) {
//		PainelOrcamento pai = new PainelOrcamento();
//		List<Produto> lista = new ArrayList<>();	
//		StringBuilder sb = new StringBuilder();
//		
//		sb.append("select * from produto where descricao ILIKE ' ");			
//		sb.append(pai.textField_1.getText());
//		sb.append("';");
//	
//		System.out.println(text);
//	
//		Connection con = ConexaoDB.getInstance().getConnection();
//
//		PreparedStatement ps;
//		try {
//			ps = con.prepareStatement(sb.toString());
//			ps.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return lista;
//		
//		
//	}


	public List<Produto> getOrcamento() {
List<Produto> lista = new ArrayList<>();		
		
		try (PreparedStatement ps = con	.prepareStatement(SQL_SELECTORC);					
				
			ResultSet rs = ps.executeQuery()) {			
			
			while (rs.next()) {
				Produto p = new Produto();				
				p.setCodigo(rs.getLong(2));
				p.setDescricao(rs.getString(3));
				p.setValorDolar(rs.getBigDecimal(4));
				p.setQuantidade(rs.getInt(5));
				lista.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
