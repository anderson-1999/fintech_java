package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Telefone;
import sem.dominio.jdbc.FintechDBManager;

public class TelefoneDAO {
	
	private Connection conexao;
	
	public void cadastrar(Telefone telefone) {
		PreparedStatement stmt = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FT_TELEFONE (id_numero, id_pessoa, num_ddi, num_ddd, numero, tp_numero) values (?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, telefone.getIdNumero());
			stmt.setInt(2, telefone.getIdPessoa());
			stmt.setString(3, telefone.getDdiDoNumero());
			stmt.setString(4, telefone.getDddDoNumero());
			stmt.setString(5, telefone.getNumeroTelefonico());
			stmt.setString(6, telefone.getTipoDoTelefone());
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}