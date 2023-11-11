package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sem.dominio.entity.Receita;
import sem.dominio.jdbc.ConnectionManager;

public class OracleReceitaDAO implements ReceitaDAO {
	private Connection conexao;

	public void cadastrar(Receita receita) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_RECEITA( id_receita, id_conta, vl_entrada, dt_entrada) VALUES (SQ_RECEITA.NEXTVAL, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, receita.getIdConta());
			stmt.setDouble(2, receita.getValorEntrada());
			java.sql.Date data = Date.valueOf(receita.getDataEntrada());
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
