package sem.dominio;

import sem.dominio.dao.InvestimentoDAO;
import sem.dominio.entity.Investimento;
import sem.dominio.factory.DAOFactory;

public class IniciarInvestimento {

	public void iniciar() {

        // criando a primeira despesa
        int id = 1;
        int idfk = 1;
        double valorInvestimento = 650.0;
        String dataInvestimento = "21/09/2023";
        int quantidadeAcao = 2;
        String nomeAcao = "Banco brasileiro";
        String codigoAcao = "BBAB";
        double valorAcao = 325.0 ;
        

        Investimento investimento1 = new Investimento(id, idfk, dataInvestimento,
        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);
        
        System.out.println("Crie o primeiro investimento " + investimento1);

        InvestimentoDAO investiementoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getInvestimentoDAO();

        investiementoDAO.insert(investimento1);

        // criando a segunda conta
        id = 2;
        idfk = 2;
        valorInvestimento = 250.0;
        dataInvestimento = "22/11/2023";
        quantidadeAcao = 50;
        nomeAcao = "Banco brasileiro";
        codigoAcao = "BBAB";
        valorAcao = 5.0 ;

        Investimento investimento2 = new Investimento(id, idfk, dataInvestimento,
        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);
        
        System.out.println("Crie o segundo investimento " + investimento2);

        investiementoDAO.insert(investimento2);

        // criando a terceira conta
        id = 3;
        idfk = 3;
        valorInvestimento = 50.0;
        dataInvestimento = "21/10/2023";
        quantidadeAcao = 1;
        nomeAcao = "Banco brasileiro";
        codigoAcao = "BBAB";
        valorAcao = 50.0 ;

        Investimento investimento3 = new Investimento(id, idfk, dataInvestimento,
        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);
         
        System.out.println("Crie o terceiro investimento " + investimento3);

        investiementoDAO.insert(investimento3);

        // criando a quarta conta
        id = 4;
        idfk = 4;
        valorInvestimento = 50.0;
        dataInvestimento = "21/10/2023";
        quantidadeAcao = 1;
        nomeAcao = "Banco brasileiro";
        codigoAcao = "BBAB";
        valorAcao = 50.0 ;


        Investimento investimento4 = new Investimento(id, idfk, dataInvestimento,
        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);
         
        System.out.println("Crie o quarto investimento " + investimento4);

        investiementoDAO.insert(investimento4);

        // criando a quinta conta
        id = 5;
        idfk = 5;
        valorInvestimento = 50.0;
        dataInvestimento = "21/10/2023";
        quantidadeAcao = 1;
        nomeAcao = "Banco brasileiro";
        codigoAcao = "BBAB";
        valorAcao = 50.0 ;

        
        Investimento investimento5 = new Investimento(id, idfk, dataInvestimento,
        		valorInvestimento, quantidadeAcao, nomeAcao, codigoAcao, valorAcao);
         
        System.out.println("Crie o quinto investimento " + investimento5);

        investiementoDAO.insert(investimento5);


        //print pessoa;
        System.out.println("imprimindo todos os investimentos");
        investiementoDAO.getAll().forEach(System.out::println);

        //print pessoa encontada
        System.out.println(investiementoDAO.getById(1));

        //deleta pessoa
        investiementoDAO.deleteById(4);

        //atualizaçao pessoa
        valorInvestimento = 6.00;

        //investiementoDAO.updateById(5, valorInvestimento);

        //verifica opcao deletada e atualizada
        investiementoDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        investiementoDAO.deleteById(6);

        //atualiza pessoa que nao existe
        //investiementoDAO.updateById(6, valorInvestimento);

        //seleciona pessoa que nao existe
        investiementoDAO.getById(6);
    }
	
}
