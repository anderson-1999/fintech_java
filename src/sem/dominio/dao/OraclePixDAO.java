package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Pix;
import sem.dominio.jdbc.ConnectionManager;

public class OraclePixDAO implements PixDAO {
	
	private Connection conexao;
	
	@Override
	public void insert(Pix pix) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_PIX (id_pix, id_conta, chave_pix, limite_transacao, qt_trasacao)"
					+ " values (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, pix.getIdPix());
			stmt.setInt(2, pix.getIdConta());
			stmt.setString(3, pix.getChavePix());
			stmt.setDouble(4, pix.getLimiteTransacao());
			stmt.setInt(5, pix.getQuantidadeTransacao());
			
			
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
	public Pix getByObject(Pix pix) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pix pixEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_PIX WHERE id_pix = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, pix.getIdConta());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_pix");
				int idFk = rs.getInt("id_conta");
				String chave = rs.getString("chave_pix");
				double limiteTransacao = rs.getDouble("limite_transacao");
				int quantidadeTransacao = rs.getInt("qt_trasacao");
				

				pixEncontrada = new Pix(idPk, idFk, chave, limiteTransacao, quantidadeTransacao);

			}

			if (pixEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma chave pix com esse id " + pix.getIdConta());
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
		return pixEncontrada;
	}

	@Override
	public Pix getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pix pix = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_PIX WHERE id_pix = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_pix");
				int idFk = rs.getInt("id_conta");
				String chave = rs.getString("chave_pix");
				double limiteTransacao = rs.getDouble("limite_transacao");
				int quantidadeTransacao = rs.getInt("qt_trasacao");
				
				pix = new Pix(idPk, idFk, chave, limiteTransacao, quantidadeTransacao);
			}

			if (pix == null) {
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
		return pix;
	}

	@Override
	public void deleteByObject(Pix pix) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_PIX WHERE id_pix = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, pix.getIdConta());

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
			String sql = "DELETE FROM T_FT_PIX WHERE id_pix = ?";
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
	public void updateById(int id, double limite, int quantidade ) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_PIX SET limite_transacao = ?, qt_trasacao = ? WHERE id_pix = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, limite);
			stmt.setInt(2, quantidade);
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
	public void updateByObject(Pix pix) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_PIX SET limite_transacao = ?, qt_trasacao = ? WHERE id_pix = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, pix.getLimiteTransacao());
			stmt.setInt(2, pix.getIdConta());
			stmt.setInt(3, pix.getIdConta());
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
	public List<Pix> getAll() {

		List<Pix> lista = new ArrayList<Pix>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_PIX");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_pix");
				int idFk = rs.getInt("id_conta");
				String chave = rs.getString("chave_pix");
				double limiteTransacao = rs.getDouble("limite_transacao");
				int quantidadeTransacao = rs.getInt("qt_trasacao");
				
				Pix pix = new Pix(idPk, idFk, chave, limiteTransacao, quantidadeTransacao);

				lista.add(pix);
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