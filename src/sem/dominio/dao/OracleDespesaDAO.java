package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Despesa;
import sem.dominio.jdbc.ConnectionManager;

public class OracleDespesaDAO implements DespesaDAO{
	private Connection conexao;

	public void insert(Despesa despesa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.obterConexao();
			String sql = "INSERT INTO T_FT_DESPESA( id_despesa, id_conta, vl_saida, dt_saida) VALUES (SQ_DESPESA.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, despesa.getIdConta());
			stmt.setDouble(2, despesa.getValorSaida());
			java.sql.Date data = Date.valueOf(despesa.getDataSaida());
			stmt.setDate(3, data);

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