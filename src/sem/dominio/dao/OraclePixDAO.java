package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Pix;
import sem.dominio.jdbc.ConnectionManager;

public class OraclePixDAO implements PixDAO {
	
	private Connection conexao;
	
	public void insert(Pix pix) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_PIX (id_pix, id_conta, chave_pix, limite_transacao, qt_transacao) values (SQ_PIX.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, pix.getIdConta());
			stmt.setString(2, pix.getChavePix());
			stmt.setDouble(3, pix.getLimiteTransacao());
			stmt.setInt(4, pix.getQuantidadeTransacao());
			
			
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