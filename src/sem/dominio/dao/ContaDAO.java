package sem.dominio.dao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Cartao;
import sem.dominio.entity.Conta;
import sem.dominio.jdbc.FintechDBManager;

public class ContaDAO {

	private Connection conexao;

	public void insert(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "INSERT INTO T_FT_CONTA " +
					"(id_conta, id_pessoa, num_agencia, num_conta, vl_saldo, vl_lis_conta, " +
					"vl_seguro_cartao, vl_cesta_produto, vl_limite_cred) " +
					"values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

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

	public Conta getByPerson(Conta conta) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Conta contaEncontrada = null;

		try {
			conexao = FintechDBManager.obterConexao();
			String sql = "SELECT * FROM T_FT_CONTA WHERE id_cartao = ?";
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
				System.out.println("Não foi encontrada nenhuma pessoa com esse id " + conta.getIdConta());
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

	public Cartao getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Cartao cartao = null;

		try {
			conexao = FintechDBManager.obterConexao();
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

	public void deleteByPerson(Cartao cartao) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
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

	public void deleteById(int id) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
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

	public void updateById(int id, String senha, double credito) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
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
				System.out.println("Houveram " + atualizado + " alteração");
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

	public void updateByPerson(Cartao cartao) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDBManager.obterConexao();
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
				System.out.println("Houveram " + atualizado + " alteração");
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

	public List<Conta> getAll() {

		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDBManager.obterConexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_CONTA");
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

				Conta conta = new Conta(idPk, idFk, numeroAgencia, numeroConta, saldo, lisConta, seguroCartao, cestaProdutos, limiteCredito, senhaConta);

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
