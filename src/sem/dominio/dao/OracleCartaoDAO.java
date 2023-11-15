package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Cartao;
import sem.dominio.jdbc.ConnectionManager;

public class OracleCartaoDAO implements CartaoDAO {
	
	private Connection conexao;
	
	@Override
	public void insert(Cartao cartao) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_CARTAO "
					+ "(id_cartao, id_conta, num_cartao, cvv, nm_no_cartao, senha_cartao, vencimento_cartao, limite_cred ) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, cartao.getIdCartao());
			stmt.setInt(2, cartao.getIdConta());
			stmt.setString(3, cartao.getNumeroDoCartao());
			stmt.setString(4, cartao.getCvv());
			stmt.setString(5, cartao.getNomeDoCartao());
			stmt.setString(6, cartao.getSenhaDoCartao());
			
			Date data = Date.valueOf(cartao.getVencimentoDoCartao());
			stmt.setDate(7, data);
			stmt.setDouble(8, cartao.getLimiteCredito());
			
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
	public Cartao getByObject(Cartao cartao) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cartao cartaoEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_CARTAO WHERE id_cartao = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, cartao.getIdCartao());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_cartao");
				int idFk = rs.getInt("id_conta");
				String numero = rs.getString("num_cartao");
				String cvv = rs.getString("cvv");
				String nome = rs.getString("nm_no_cartao");
				String senha = rs.getString("senha_cartao");
				Date date = rs.getDate("vencimento_cartao");
				LocalDate data = date.toLocalDate();
				double credito = rs.getDouble("limite_cred");

				cartaoEncontrada = new Cartao(idPk, idFk, numero, cvv, nome, senha, data, credito);

			}
			
			if (cartaoEncontrada == null) {
				System.out.println("Não foi encontrada Cartão com o id " + cartao.getIdConta());
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
		return cartaoEncontrada;
	}
	
	@Override
	public Cartao getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cartao cartao = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_CARTAO WHERE id_cartao = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_cartao");
				int idFk = rs.getInt("id_conta");
				String numero = rs.getString("num_cartao");
				String cvv = rs.getString("cvv");
				String nome = rs.getString("nm_no_cartao");
				String senha = rs.getString("senha_cartao");
				Date date = rs.getDate("vencimento_cartao");
				LocalDate data = date.toLocalDate();
				double credito = rs.getDouble("limite_cred");

				cartao = new Cartao(idPk, idFk, numero, cvv, nome, senha, data, credito);
			}
			
			if (cartao == null) {
				System.out.print("Não foi encontrada nenhum cartão com esse id " + id);
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
		return cartao;
	}

	@Override
	public void deleteByObject(Cartao cartao) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_CARTAO WHERE id_cartao = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, cartao.getIdCartao());

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
			String sql = "DELETE FROM T_FT_CARTAO WHERE id_cartao = ?";
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
	public void updateByObject(Cartao cartao) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_CARTAO SET senha_cartao = ?, limite_cred = ?  WHERE id_cartao = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, cartao.getSenhaDoCartao());
			stmt.setDouble(2, cartao.getLimiteCredito());
			stmt.setInt(3, cartao.getIdCartao());

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
	public void updateById(int id, String senha, double credito) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_CARTAO SET senha_cartao = ?, limite_cred = ?  WHERE id_cartao = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, senha);
			stmt.setDouble(2, credito);
			stmt.setInt(3, id);

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
	public List<Cartao> getAll() {

		List<Cartao> lista = new ArrayList<Cartao>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.createStatement();
			rs = stmt.executeQuery("SELECT * FROM T_FT_CARTAO");

			while (rs.next()) {

				int idPk = rs.getInt("id_cartao");
				int idFk = rs.getInt("id_conta");
				String numero = rs.getString("num_cartao");
				String cvv = rs.getString("cvv");
				String nome = rs.getString("nm_no_cartao");
				String senha = rs.getString("senha_cartao");
				Date date = rs.getDate("vencimento_cartao");
				LocalDate data = date.toLocalDate();
				double credito = rs.getDouble("limite_cred");

				Cartao cartao = new Cartao(idPk, idFk, numero, cvv, nome, senha, data, credito);
				lista.add(cartao);

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
