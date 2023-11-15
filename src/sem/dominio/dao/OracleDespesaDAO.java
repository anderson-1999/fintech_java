package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Despesa;
import sem.dominio.jdbc.ConnectionManager;

public class OracleDespesaDAO implements DespesaDAO{
	private Connection conexao;

	@Override
	public void insert(Despesa despesa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_DESPESA( id_despesa, id_conta, vl_saida, dt_saida) VALUES (?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, despesa.getIdDespesa());
			stmt.setInt(2, despesa.getIdConta());
			stmt.setDouble(3, despesa.getValorSaida());
			
			java.sql.Date data = Date.valueOf(despesa.getDataSaida());
			stmt.setDate(4, data);

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
	
	@Override
	public Despesa getByObject(Despesa despesa) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Despesa despesaEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_DESPESA WHERE id_despesa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, despesa.getIdConta());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_despesa");
				int idFk = rs.getInt("id_conta");
				double saldo = rs.getDouble("vl_saida");
				
				Date date = rs.getDate("dt_saida");
				LocalDate data = date.toLocalDate();
				

				despesaEncontrada = new Despesa(idPk, idFk,  saldo, data);

			}

			if (despesaEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma despesa com esse id " + despesa.getIdConta());
			}

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
		return despesaEncontrada;
	}

	@Override
	public Despesa getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Despesa despesa = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_DESPESA WHERE id_despesa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_despesa");
				int idFk = rs.getInt("id_conta");
				double saldo = rs.getDouble("vl_saida");
				
				Date date = rs.getDate("dt_saida");
				LocalDate data = date.toLocalDate();
				

				despesa = new Despesa(idPk, idFk,  saldo, data);

			}

			if (despesa == null) {
				System.out.print("Não foi encontrada nenhum conta com esse id " + id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return despesa;
	}

	@Override
	public void deleteByObject(Despesa despesa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_DESPESA WHERE id_despesa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, despesa.getIdConta());

			int deletado = stmt.executeUpdate();

			if (deletado == 0) {
				System.out.println("Não Houve exclusão");
			}
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

	@Override
	public void deleteById(int id) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_DESPESA WHERE id_despesa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);

			int deletado = stmt.executeUpdate();

			if (deletado == 0) {
				System.out.println("Não Houve exclusão");
			}
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

	public void updateById(int id, double valor) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_DESPESA SET vl_saida = ?  WHERE id_despesa = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, valor);
			
			stmt.setInt(2, id);

			int atualizado = stmt.executeUpdate();



			if (atualizado == 0) {
				System.out.println("Não houve alteração");
			} else if(atualizado == 1) {
				System.out.println("Houve 1 alteração");
			} else {
				System.out.println("Houveram " + atualizado + " alterações");
			}
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

	@Override
	public void updateByObject(Despesa despesa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_DESPESA SET vl_saida = ?  WHERE id_despesa = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, despesa.getValorSaida());
			stmt.setInt(2, despesa.getIdDespesa());
			
			int atualizado = stmt.executeUpdate();

			if (atualizado == 0) {
				System.out.println("Não houve alteração");
			} else if(atualizado == 1) {
				System.out.println("Houve 1 alteração");
			} else {
				System.out.println("Houveram " + atualizado + " alterações");
			}
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

	@Override
	public List<Despesa> getAll() {

		List<Despesa> lista = new ArrayList<Despesa>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_DESPESA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_despesa");
				int idFk = rs.getInt("id_conta");
				double saldo = rs.getDouble("vl_saida");
				
				Date date = rs.getDate("dt_saida");
				LocalDate data = date.toLocalDate();
				

				Despesa despesa = new Despesa(idPk, idFk,  saldo, data);

				lista.add(despesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}
}