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

import sem.dominio.entity.Pessoa;
import sem.dominio.jdbc.ConnectionManager;

public class OraclePessoaDAO implements PessoaDAO {
	protected Connection conexao;

	public OraclePessoaDAO() {
		PreparedStatement stmt = null;
		ResultSet rs;
		int idFinal = 1;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("""
                    SELECT * FROM (SELECT * FROM T_FT_PESSOA
                    					ORDER BY id_pessoa DESC)
                    					WHERE ROWNUM <= 1""");
			rs = stmt.executeQuery();
			while (rs.next()) {
				idFinal = rs.getInt("id_pessoa");
				idFinal++;
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

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "CREATE SEQUENCE SQ_PESSOA START WITH " + idFinal + " INCREMENT BY 1";
			stmt = conexao.prepareCall(sql);
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

	public void insert(Pessoa pessoa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_PESSOA (id_pessoa, num_cpf_cnpj, nome, sobrenome, email, dt_nascimento)"
					+ "values (SQ_PESSOA.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);

			// stmt.setInt(1, pessoa.getIdConta());

			stmt.setString(1, pessoa.getNumeroCpfCnpj());
			stmt.setString(2, pessoa.getNome());
			stmt.setString(3, pessoa.getSobrenome());
			stmt.setString(4, pessoa.getEmail());

			Date data = Date.valueOf(pessoa.getDataNascimento());
			stmt.setDate(5, data);

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

	public Pessoa getByObject(Pessoa pessoa) {
		PreparedStatement stmt = null;
		ResultSet rs;
		Pessoa pessoaEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_PESSOA WHERE id_pessoa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, pessoa.getIdPessoa());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_pessoa");
				// int idFk = rs.getInt("id_conta");
				String cpfCnpj = rs.getString("num_cpf_cnpj");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				Date date = rs.getDate("dt_nascimento");
				LocalDate data = date.toLocalDate();

				pessoaEncontrada = new Pessoa(idPk, nome, email, data, cpfCnpj, sobrenome);

			}
			
			if (pessoaEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma pessoa com esse id" + pessoa.getIdPessoa());
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
		return pessoaEncontrada;
	}

	public Pessoa getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Pessoa pessoa = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_PESSOA WHERE id_pessoa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_pessoa");
				// int idFk = rs.getInt("id_conta");
				String cpfCnpj = rs.getString("num_cpf_cnpj");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				Date date = rs.getDate("dt_nascimento");
				LocalDate data = date.toLocalDate();

				pessoa = new Pessoa(idPk, nome, email, data, cpfCnpj, sobrenome);
			}
			
			if (pessoa == null) {
				System.out.print("Não foi encontrada nenhuma pessoa com esse id" + id);
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
		return pessoa;
	}

	public void deleteByPerson(Pessoa pessoa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_PESSOA WHERE id_pessoa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, pessoa.getIdPessoa());

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
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_PESSOA WHERE id_pessoa = ?";
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

	public void updateById(int id, String novoValor) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_PESSOA SET email = ? WHERE id_pessoa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, novoValor);
			stmt.setInt(2, id);

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

	public void updateByPerson(Pessoa pessoa) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_PESSOA SET email = ?  WHERE id_pessoa = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, pessoa.getEmail());
			stmt.setInt(2, pessoa.getIdPessoa());

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

	public List<Pessoa> getAll() {

		List<Pessoa> lista = new ArrayList<Pessoa>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.createStatement();
			rs = stmt.executeQuery("SELECT * FROM T_FT_PESSOA");

			while (rs.next()) {

				int idPk = rs.getInt("id_pessoa");
				// int idFk = rs.getInt("id_conta");
				String cpfCnpj = rs.getString("num_cpf_cnpj");
				String nome = rs.getString("nome");
				String sobrenome = rs.getString("sobrenome");
				String email = rs.getString("email");
				java.sql.Date date = rs.getDate("dt_nascimento");
				LocalDate data = date.toLocalDate();

				Pessoa pessoa = new Pessoa(idPk, nome, email, data, cpfCnpj, sobrenome);
				lista.add(pessoa);

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
