package br.casa;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class ProdutoDao {
	
	
	private static final String SQL_SELECTALL = "select * from produto;";
	private static final String SQL_SELECT = "select * from produto where descricao ILIKE 'a%';";
	private static final String SQL_INSERT = "insert into orcamento1(codigo, descricao,valor,quantidade)values(?, ?, ?, ?)";
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
			//ps.setBigDecimal(4, p.getValorDolar().multiply(p.getDolar()));
			
			ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<Produto> getTodos() {
		
		List<Produto> lista = new ArrayList<>();
		
		
		try (PreparedStatement ps = con	.prepareStatement(SQL_SELECT);				
				
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
//	public List<Produto> getTodos() {
//		
//		List<Produto> lista = new ArrayList<>();
//		try (PreparedStatement ps = con	.prepareStatement(SQL_SELECT);				
//				
//			ResultSet rs = ps.executeQuery()) {		
//			while (rs.next()) {
//				
//				Produto p = new Produto();
//				p.setCodigo(rs.getLong(2));
//				p.setDescricao(rs.getString(3));
//				p.setValorDolar(rs.getBigDecimal(4));
//				lista.add(p);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return lista;
//		
//		
//	}

}
