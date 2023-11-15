package sem.dominio.factory;

import sem.dominio.dao.CartaoDAO;
import sem.dominio.dao.ContaDAO;
import sem.dominio.dao.DespesaDAO;
import sem.dominio.dao.EnderecoDAO;
import sem.dominio.dao.InvestimentoDAO;
import sem.dominio.dao.PessoaDAO;
import sem.dominio.dao.PixDAO;
import sem.dominio.dao.ReceitaDAO;
import sem.dominio.dao.TelefoneDAO;

public abstract class DAOFactory {
	
	public static final int ORACLE = 1;
	
	private static DAOFactory oracleDAOFactory;
	
	public static DAOFactory getDAOFactory(int banco) {
		switch(banco) {
		case ORACLE:
			if(oracleDAOFactory == null) {
				oracleDAOFactory = new OracleDAOFactory();
				return oracleDAOFactory;
			}
		default:
			return null;
		}
	}
	
	public abstract CartaoDAO getCartaoDAO();
	
	public abstract ContaDAO getContaDAO();
	
	public abstract DespesaDAO getDespesaDAO();
	
	public abstract EnderecoDAO getEnderecoDAO();
	
	public abstract InvestimentoDAO getInvestimentoDAO();
	
	public abstract PessoaDAO getPessoaDAO();
	
	public abstract PixDAO getPixDAO();

	public abstract ReceitaDAO getReceitaDAO();

	public abstract TelefoneDAO getTelefoneDAO();

}
