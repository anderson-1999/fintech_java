package sem.dominio.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Conta;
import sem.dominio.jdbc.ConnectionManager;

public class OracleContaDAO implements ContaDAO {

	private Connection conexao;

	@Override
	public void insert(Conta conta) {
		
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_CONTA " +
					"(id_conta, id_pessoa, num_agencia, num_conta, saldo, lis_conta, " +
					"seguro_cartao, cesta_produto, limite_cred, senha_conta) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, conta.getIdConta());
			stmt.setInt(2, conta.getIdPessoa());
			stmt.setString(3, conta.getNumeroDaAgencia());
			stmt.setString(4, conta.getNumeroDaConta());
			stmt.setDouble(5, conta.getSaldo());
			stmt.setDouble(6, conta.getLisConta());
			stmt.setDouble(7, conta.getSeguroCartao());
			stmt.setDouble(8, conta.getCestaDeProduto());
			stmt.setDouble(9, conta.getLimiteCredito());
			stmt.setString(10, conta.getSenhaConta());

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
	public Conta getByObject(Conta conta) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Conta contaEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_CONTA WHERE id_conta = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, conta.getIdConta());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_conta");
				int idFk = rs.getInt("id_pessoa");
				String agencia = rs.getString("num_agencia");
				String numConta = rs.getString("num_conta");
				double saldo = rs.getDouble("saldo");
				double lisConta = rs.getDouble("lis_conta");
				double seguroCartao = rs.getDouble("seguro_cartao");
				double cestaProdutos = rs.getDouble("cesta_produto");
				double credito = rs.getDouble("limite_cred");
				String senha = rs.getString("senha_conta");

				contaEncontrada = new Conta(idPk, idFk, agencia, numConta, saldo, lisConta,
						seguroCartao, cestaProdutos, credito, senha);

			}

			if (contaEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma conta com esse id " + conta.getIdConta());
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
		return contaEncontrada;
	}

	@Override
	public Conta getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Conta conta = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_CONTA WHERE id_conta = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_conta");
				int idFk = rs.getInt("id_pessoa");
				String agencia = rs.getString("num_agencia");
				String numConta = rs.getString("num_conta");
				double saldo = rs.getDouble("saldo");
				double lisConta = rs.getDouble("lis_conta");
				double seguroCartao = rs.getDouble("seguro_cartao");
				double cestaProdutos = rs.getDouble("cesta_produto");
				double credito = rs.getDouble("limite_cred");
				String senha = rs.getString("senha_conta");

				conta = new Conta(idPk, idFk, agencia, numConta, saldo, lisConta,
						seguroCartao, cestaProdutos, credito, senha);
			}

			if (conta == null) {
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
		return conta;
	}

	@Override
	public void deleteByObject(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_CONTA WHERE id_conta = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, conta.getIdConta());

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
			String sql = "DELETE FROM T_FT_CONTA WHERE id_conta = ?";
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
	public void updateById(int id, String senha, double saldo, double lis, double seguro, double cesta, double limite) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_CONTA SET saldo = ?, lis_conta = ?, seguro_cartao = ?,"
					+ " cesta_produto = ?, limite_cred = ?, senha_conta = ?  WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, saldo);
			stmt.setDouble(2, lis);
			stmt.setDouble(3, seguro);
			stmt.setDouble(4, cesta);
			stmt.setDouble(5, limite);
			stmt.setString(6, senha);
			stmt.setInt(7, id);

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
	public void updateByObject(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_CONTA SET saldo = ?, lis_conta = ?, seguro_cartao = ?,"
					+ " cesta_produto = ?, limite_cred = ?, senha_conta = ?  WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setDouble(1, conta.getSaldo());
			stmt.setDouble(2, conta.getLisConta());
			stmt.setDouble(3, conta.getSeguroCartao());
			stmt.setDouble(4, conta.getCestaDeProduto());
			stmt.setDouble(5, conta.getLimiteCredito());
			stmt.setString(6, conta.getSenhaConta());
			stmt.setInt(7, conta.getIdConta());
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
	public List<Conta> getAll() {

		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_DESPESA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_conta");
				int idFk = rs.getInt("id_pessoa");
				String numeroAgencia = rs.getString("num_agencia");
				String numeroConta = rs.getString("num_conta");
				double saldo = rs.getDouble("saldo");
				double lisConta = rs.getDouble("lis_conta");
				double seguroCartao = rs.getDouble("seguro_cartao");
				double cestaProdutos = rs.getDouble("cesta_produto");
				double limiteCredito = rs.getDouble("limite_cred");
				String senhaConta = rs.getString("senha_conta");

				Conta conta = new Conta(idPk, idFk, numeroAgencia, numeroConta, saldo, lisConta,
						seguroCartao, cestaProdutos, limiteCredito, senhaConta);

				lista.add(conta);
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
