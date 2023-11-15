package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Receita;
import sem.dominio.jdbc.ConnectionManager;

public class OracleReceitaDAO implements ReceitaDAO {
	private Connection conexao;

	@Override
	public void insert(Receita receita) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_RECEITA( id_receita, id_conta, vl_entrada, dt_entrada) VALUES (?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, receita.getIdReceita());
			stmt.setInt(2, receita.getIdConta());
			stmt.setDouble(3, receita.getValorEntrada());
			
			java.sql.Date data = Date.valueOf(receita.getDataEntrada());
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
	public Receita getByObject(Receita receita) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Receita receitaEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_RECEITA WHERE id_receita = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, receita.getIdConta());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_receita");
				int idFk = rs.getInt("id_conta");
				double valorReceita = rs.getDouble("vl_entrada");
				Date data = rs.getDate("dt_entrada");
				LocalDate dataReceita =  data.toLocalDate();

				receitaEncontrada = new Receita(idPk, idFk, valorReceita, dataReceita);

			}

			if (receitaEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma conta com esse id " + receita.getIdConta());
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
		return receitaEncontrada;
	}

	@Override
	public Receita getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Receita receita = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_RECEITA WHERE id_receita = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_receita");
				int idFk = rs.getInt("id_conta");
				double valorReceita = rs.getDouble("vl_entrada");
				Date data = rs.getDate("dt_entrada");
				LocalDate dataReceita =  data.toLocalDate();

				receita = new Receita(idPk, idFk, valorReceita, dataReceita);
			}

			if (receita == null) {
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
		return receita;
	}

	@Override
	public void deleteByObject(Receita receita) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_RECEITA WHERE id_receita = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, receita.getIdConta());

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
			String sql = "DELETE FROM T_FT_RECEITA WHERE id_receita = ?";
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

	@Override
	public void updateById(int id, double valorReceita) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_RECEITA SET vl_entrada = ? WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, valorReceita);
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
	public void updateByObject(Receita receita) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_RECEITA SET vl_entrada = ? WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, receita.getValorEntrada());
			stmt.setInt(2, receita.getIdReceita());
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
	public List<Receita> getAll() {

		List<Receita> lista = new ArrayList<Receita>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_RECEITA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_receita");
				int idFk = rs.getInt("id_conta");
				double valorReceita = rs.getDouble("vl_entrada");
				
				Date data = rs.getDate("dt_entrada");
				LocalDate dataReceita =  data.toLocalDate();

				Receita receita = new Receita(idPk, idFk, valorReceita, dataReceita);

				lista.add(receita);
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
