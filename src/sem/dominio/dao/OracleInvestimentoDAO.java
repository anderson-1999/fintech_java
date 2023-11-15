package sem.dominio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Investimento;
import sem.dominio.jdbc.ConnectionManager;

public class OracleInvestimentoDAO implements InvestimentoDAO {
	private Connection conexao;
	
	@Override
	public void insert(Investimento investimento) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_INVESTIMENTO( id_investimento, id_conta, dt_investimento,"
					+ " vl_investimento, qt_acao, nm_acao, cod_acao, vl_acao ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, investimento.getIdInvestimento());
			stmt.setInt(2, investimento.getIdConta());
			
			java.sql.Date data = Date.valueOf(investimento.getDataInvestimento());
			stmt.setDate(3, data);
			stmt.setDouble(4, investimento.getValorInvestimento());
			stmt.setInt(5, investimento.getQuantidadeAcao());
			stmt.setString(6, investimento.getNomeAcao());
			stmt.setString(7, investimento.getCodigoAcao());
			stmt.setDouble(8, investimento.getValorAcao());

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
	public Investimento getByObject(Investimento investimento) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Investimento investimentoEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_INVESTIMENTO WHERE id_investimento = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, investimento.getIdConta());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_investimento");
				int idFk = rs.getInt("id_conta");
				
				Date date = rs.getDate("dt_investimento");
				LocalDate dataInvestimento = date.toLocalDate();
				double valorInvestimento = rs.getDouble("vl_investimento");
				int quantidadeAcao = rs.getInt("qt_acao");
				String nomeAcao = rs.getString("nm_acao");
				String codigoAcao = rs.getString("cod_acao");
				double valorAcao = rs.getDouble("vl_acao");

				investimentoEncontrada = new Investimento(idPk, idFk, dataInvestimento,
		        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);

			}

			if (investimentoEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma investimento com esse id " + investimento.getIdConta());
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
		return investimentoEncontrada;
	}

	@Override
	public Investimento getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Investimento investimento = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_INVESTIMENTO WHERE id_investimento = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_investimento");
				int idFk = rs.getInt("id_conta");
				
				Date date = rs.getDate("dt_investimento");
				LocalDate dataInvestimento = date.toLocalDate();
				double valorInvestimento = rs.getDouble("vl_investimento");
				int quantidadeAcao = rs.getInt("qt_acao");
				String nomeAcao = rs.getString("nm_acao");
				String codigoAcao = rs.getString("cod_acao");
				double valorAcao = rs.getDouble("vl_acao");

				investimento = new Investimento(idPk, idFk, dataInvestimento,
		        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);
			}

			if (investimento == null) {
				System.out.print("Não foi encontrada nenhum investimento com esse id " + id);
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
		return investimento;
	}

	@Override
	public void deleteByObject(Investimento investimento) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_INVESTIMENTO WHERE id_investimento = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, investimento.getIdConta());

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
			String sql = "DELETE FROM T_FT_INVESTIMENTO WHERE id_investimento = ?";
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
	public void updateById(int id, double valorTotal, double valorAcao) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_INVESTIMENTO SET vl_investimento = ?, vl_acao = ? WHERE id_investimento = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, valorTotal);
			stmt.setDouble(2, valorAcao);
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
	public void updateByObject(Investimento investimento) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_INVESTIMENTO SET vl_investimento = ?, vl_acao = ? WHERE id_investimento = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, investimento.getValorInvestimento());
			stmt.setDouble(2, investimento.getValorAcao());
			stmt.setInt(3, investimento.getIdInvestimento());
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
	public List<Investimento> getAll() {

		List<Investimento> lista = new ArrayList<Investimento>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_INVESTIMENTO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_investimento");
				int idFk = rs.getInt("id_conta");
				
				Date date = rs.getDate("dt_investimento");
				LocalDate dataInvestimento = date.toLocalDate();
				double valorInvestimento = rs.getDouble("vl_investimento");
				int quantidadeAcao = rs.getInt("qt_acao");
				String nomeAcao = rs.getString("nm_acao");
				String codigoAcao = rs.getString("cod_acao");
				double valorAcao = rs.getDouble("vl_acao");

				Investimento investimento = new Investimento(idPk, idFk, dataInvestimento,
		        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);

				lista.add(investimento);
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