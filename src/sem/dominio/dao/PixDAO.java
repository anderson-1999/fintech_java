package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Pix;
import sem.dominio.jdbc.FintechDBManager;

public class PixDAO {
	
	private Connection conexao;
	
	public void cadastrar(Pix pix) {
		PreparedStatement stmt = null;
		
		try {
			conexao = FintechDBManager.obterConexao();
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