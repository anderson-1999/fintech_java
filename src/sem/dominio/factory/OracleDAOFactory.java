package sem.dominio.factory;

import sem.dominio.dao.CartaoDAO;
import sem.dominio.dao.ContaDAO;
import sem.dominio.dao.DespesaDAO;
import sem.dominio.dao.EnderecoDAO;
import sem.dominio.dao.InvestimentoDAO;
import sem.dominio.dao.OracleCartaoDAO;
import sem.dominio.dao.OracleContaDAO;
import sem.dominio.dao.OracleDespesaDAO;
import sem.dominio.dao.OracleEnderecoDAO;
import sem.dominio.dao.OracleInvestimentoDAO;
import sem.dominio.dao.OraclePessoaDAO;
import sem.dominio.dao.OraclePixDAO;
import sem.dominio.dao.OracleReceitaDAO;
import sem.dominio.dao.OracleTelefoneDAO;
import sem.dominio.dao.PessoaDAO;
import sem.dominio.dao.PixDAO;
import sem.dominio.dao.ReceitaDAO;
import sem.dominio.dao.TelefoneDAO;

public class OracleDAOFactory extends DAOFactory {

	@Override
	public CartaoDAO getCartaoDAO() {
		return new OracleCartaoDAO();
	}

	@Override
	public ContaDAO getContaDAO() {
		return new OracleContaDAO();
	}

	@Override
	public DespesaDAO getDespesaDAO() {
		return new OracleDespesaDAO();
	}

	@Override
	public EnderecoDAO getEnderecoDAO() {
		// TODO Auto-generated method stub
		return new OracleEnderecoDAO();
	}

	@Override
	public InvestimentoDAO getInvestimentoDAO() {
		return new OracleInvestimentoDAO();
	}

	@Override
	public PessoaDAO getPessoaDAO() {
		return new OraclePessoaDAO();
	}

	@Override
	public PixDAO getPixDAO() {
		return new OraclePixDAO();
	}

	@Override
	public ReceitaDAO getReceitaDAO() {
		return new OracleReceitaDAO();
	}

	@Override
	public TelefoneDAO getTelefoneDAO() {
		return new OracleTelefoneDAO();
	}

}
