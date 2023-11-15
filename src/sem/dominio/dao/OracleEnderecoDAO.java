package sem.dominio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sem.dominio.entity.Endereco;
import sem.dominio.jdbc.ConnectionManager;

public class OracleEnderecoDAO implements EnderecoDAO {
	
	private Connection conexao;
	
	@Override
	public void insert(Endereco endereco) {
		PreparedStatement stmt = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_FT_ENDERECO (id_endereco, id_pessoa, num_cep, nm_barrio, tp_logradouro,"
					+ " nm_logradoro, numero, complemento, tp_endereco) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			
			stmt.setInt(1, endereco.getIdEndereco());
			stmt.setInt(2, endereco.getIdPessoa());
			stmt.setString(3, endereco.getNumeroDoCep());
			stmt.setString(4, endereco.getNomeBarrio());
			stmt.setString(5, endereco.getTipoLogradouro());
			stmt.setString(6, endereco.getNomeLogradouro());
			stmt.setString(7, endereco.getNumeroDaResidencia());
			stmt.setString(8, endereco.getComplemento());
			stmt.setString(9, endereco.getTipoDaResidencia());
			
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
	public Endereco getByObject(Endereco endereco) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Endereco enderecoEncontrada = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_ENDERECO WHERE id_endereco = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, endereco.getIdEndereco());
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_endereco");
				int idFk = rs.getInt("id_pessoa");
				String cep = rs.getString("num_cep");
				String barrio = rs.getString("nm_barrio");
				String tipoLogradouro = rs.getString("tp_logradouro");
				String nomeLogradouro = rs.getString("nm_logradoro");
				String complemento = rs.getString("numero");
				String numero = rs.getString("complemento");
				String tipoResidencia = rs.getString("tp_endereco");

				enderecoEncontrada = new Endereco(idPk, idFk, cep, barrio, tipoLogradouro, nomeLogradouro,
						complemento, numero, tipoResidencia);

			}

			if (enderecoEncontrada == null) {
				System.out.println("Não foi encontrada nenhuma endereço com esse id " + endereco.getIdEndereco());
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
		return enderecoEncontrada;
	}

	@Override
	public Endereco getById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Endereco endereco = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "SELECT * FROM T_FT_ENDERECO WHERE id_endereco = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_endereco");
				int idFk = rs.getInt("id_pessoa");
				String cep = rs.getString("num_cep");
				String barrio = rs.getString("nm_barrio");
				String tipoLogradouro = rs.getString("tp_logradouro");
				String nomeLogradouro = rs.getString("nm_logradoro");
				String complemento = rs.getString("numero");
				String numero = rs.getString("complemento");
				String tipoResidencia = rs.getString("tp_endereco");

				endereco = new Endereco(idPk, idFk, cep, barrio, tipoLogradouro, nomeLogradouro,
						complemento, numero, tipoResidencia);
			}

			if (endereco == null) {
				System.out.print("Não foi encontrada nenhum endereço com esse id " + id);
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
		return endereco;
	}

	@Override
	public void deleteByObject(Endereco endereco) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_FT_ENDERECO WHERE id_endereco = ?";
			stmt = conexao.prepareStatement(sql);

			stmt.setInt(1, endereco.getIdEndereco());

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
			String sql = "DELETE FROM T_FT_ENDERECO WHERE id_endereco = ?";
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
	public void updateById(int id, String numeroDoCep, String nomeBarrio, String tipoLogradouro, String nomeLogradouro,
			String numeroDaResidencia, String complemento, String tipoDaResidencia) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			String sql = "UPDATE T_FT_ENDERECO SET num_cep = ?, nm_barrio = ?, tp_logradouro = ?,"
					+ " nm_logradoro = ?, numero = ?, complemento = ?, tp_endereco  WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, numeroDoCep);
			stmt.setString(2, nomeBarrio);
			stmt.setString(3, tipoLogradouro);
			stmt.setString(4, nomeLogradouro);
			stmt.setString(5, numeroDaResidencia);
			stmt.setString(6, complemento);
			stmt.setString(7, tipoDaResidencia);
			
			stmt.setInt(9, id);
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
	public void updateByObject(Endereco endereco) {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_FT_ENDERECO SET num_cep = ?, nm_barrio = ?, tp_logradouro = ?,"
					+ " nm_logradoro = ?, numero = ?, complemento = ?, tp_endereco  WHERE id_conta = ?";
			
			stmt = conexao.prepareStatement(sql);

			stmt.setString(1, endereco.getNumeroDoCep());
			stmt.setString(2, endereco.getNomeBarrio());
			stmt.setString(3, endereco.getTipoLogradouro());
			stmt.setString(4, endereco.getNomeLogradouro());
			stmt.setString(5, endereco.getNumeroDaResidencia());
			stmt.setString(6, endereco.getComplemento());
			stmt.setString(7, endereco.getTipoDaResidencia());
			
			stmt.setInt(9, endereco.getIdEndereco());
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
	public List<Endereco> getAll() {

		List<Endereco> lista = new ArrayList<Endereco>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			stmt = conexao.prepareStatement("SELECT * FROM T_FT_ENDERECO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idPk = rs.getInt("id_endereco");
				int idFk = rs.getInt("id_pessoa");
				String cep = rs.getString("num_cep");
				String barrio = rs.getString("nm_barrio");
				String tipoLogradouro = rs.getString("tp_logradouro");
				String nomeLogradouro = rs.getString("nm_logradoro");
				String complemento = rs.getString("numero");
				String numero = rs.getString("complemento");
				String tipoResidencia = rs.getString("tp_endereco");

				Endereco endereco = new Endereco(idPk, idFk, cep, barrio, tipoLogradouro, nomeLogradouro,
						complemento, numero, tipoResidencia);

				lista.add(endereco);
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