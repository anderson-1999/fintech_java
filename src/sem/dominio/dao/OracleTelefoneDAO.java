package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Telefone;
import sem.dominio.jdbc.ConnectionManager;

public class OracleTelefoneDAO implements TelefoneDAO {
	
	private Connection conexao;
	
	public void insert(Telefone telefone) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_TELEFONE (id_numero, id_pessoa, ddi, ddd, numero, tp_numero)"
					+ " values (?, ?, ?, ?, ?, ?)";
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
	
	@Override
	public Telefone getByObject(Telefone telefone) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Telefone telefoneEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_TELEFONE WHERE id_numero = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, telefone.getIdNumero());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_numero");
				int idFk = rs.getInt("id_pessoa");
				String ddi = rs.getString("ddi");
				String ddd = rs.getString("ddd");
				String numero = rs.getString("numero");
				String tipo = rs.getString("tp_numero");

				telefoneEncontrada = new Telefone(idPk, idFk, ddi, ddd, numero, tipo);

			}

			if (telefoneEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma numero com esse id " + telefone.getIdNumero());
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
		return telefoneEncontrada;
	}

	@Override
	public Telefone getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Telefone telefone = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_TELEFONE WHERE id_numero = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_numero");
				int idFk = rs.getInt("id_pessoa");
				String ddi = rs.getString("ddi");
				String ddd = rs.getString("ddd");
				String numero = rs.getString("numero");
				String tipo = rs.getString("tp_numero");

				telefone = new Telefone(idPk, idFk, ddi, ddd, numero, tipo);

			}

			if (telefone == null) {
				System.out.print("Não foi encontrada nenhum telefone com esse id " + id);
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
		return telefone;
	}

	@Override
	public void deleteByObject(Telefone telefone) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_TELEFONE WHERE id_numero = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, telefone.getIdNumero());

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
			String sql = "DELETE FROM T_FT_TELEFONE WHERE id_numero = ?";
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
	public void updateById(int id, String ddi, String ddd, String numero, String tipo) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_TELEFONE SET ddi = ?, ddd = ?, numero = ?,"
					+ " tp_numero = ?  WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, ddi);
			stmt.setString(2, ddd);
			stmt.setString(3, numero);
			stmt.setString(4, tipo);
			stmt.setInt(5, id);

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
	public void updateByObject(Telefone telefone) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_TELEFONE SET ddi = ?, ddd = ?, numero = ?,"
					+ " tp_numero = ?  WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, telefone.getDdiDoNumero());
			stmt.setString(2, telefone.getDddDoNumero());
			stmt.setString(3, telefone.getNumeroTelefonico());
			stmt.setString(4, telefone.getTipoDoTelefone());
			stmt.setInt(5, telefone.getIdNumero());
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
	public List<Telefone> getAll() {

		List<Telefone> lista = new ArrayList<Telefone>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_TELEFONE");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_numero");
				int idFk = rs.getInt("id_pessoa");
				String ddi = rs.getString("ddi");
				String ddd = rs.getString("ddd");
				String numero = rs.getString("numero");
				String tipo = rs.getString("tp_numero");

				Telefone telefone = new Telefone(idPk, idFk, ddi, ddd, numero, tipo);

				lista.add(telefone);
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