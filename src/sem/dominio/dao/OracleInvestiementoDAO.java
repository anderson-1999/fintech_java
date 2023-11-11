package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Investimento;
import sem.dominio.jdbc.ConnectionManager;

public class OracleInvestiementoDAO implements InvestimentoDAO {
	private Connection conexao;
	
	public void insert(Investimento investimento) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_INVESTIMENTO( id_investimento, id_conta, dt_investimento, vl_investimento, qt_acao, nm_acao, cod_acao, vl_acao ) VALUES (SQ_INVESTIMENTO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, investimento.getIdConta());
			java.sql.Date data = Date.valueOf(investimento.getDataInvestimento());
			stmt.setDate(2, data);
			stmt.setDouble(3, investimento.getValorInvestimento());
			stmt.setInt(4, investimento.getQuantidadeAcao());
			stmt.setString(5, investimento.getNomeAcao());
			stmt.setString(6, investimento.getCodigoAcao());
			stmt.setDouble(7, investimento.getValorAcao());

			
			stmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conexao.close();
				} catch (SQLException e) {
	        	  e.printStackTrace();
				}
	        }
	}
}