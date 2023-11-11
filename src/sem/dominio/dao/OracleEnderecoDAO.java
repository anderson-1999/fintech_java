package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Endereco;
import sem.dominio.jdbc.ConnectionManager;

public class OracleEnderecoDAO implements EnderecoDAO {
	
	private Connection conexao;
	
	public void insert(Endereco endereco) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_ENDERECO (id_endereco, id_pessoa, num_cep, nm_barrio, tp_logradouro, nm_logradouro, numero, complemento, tp_endereco) values (SQ_ENDERECO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, endereco.getIdPessoa());
			stmt.setString(2, endereco.getNumeroDoCep());
			stmt.setString(3, endereco.getNomeBarrio());
			stmt.setString(4, endereco.getTipoLogradouro());
			stmt.setString(5, endereco.getNomeLogradouro());
			stmt.setString(6, endereco.getNumeroDaResidencia());
			stmt.setString(7, endereco.getComplemento());
			stmt.setString(8, endereco.getTipoDaResidencia());
			
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