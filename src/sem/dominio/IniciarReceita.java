package sem.dominio;

import sem.dominio.dao.ReceitaDAO;
import sem.dominio.entity.Receita;
import sem.dominio.factory.DAOFactory;

public class IniciarReceita {
	
	public void iniciar() {

        // criando a primeira despesa
        int id = 1;
        int idfk = 1;
        double valorEntrada = 550.50;
        String dataEntrada = "11/09/2023";

        Receita receita1 = new Receita(id, idfk, valorEntrada, dataEntrada);
        System.out.println("Crie a primeira receita " + receita1);

        ReceitaDAO receitaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getReceitaDAO();

        receitaDAO.insert(receita1);

        // criando a segunda conta
        id = 2;
        idfk = 2;
        valorEntrada = 55.50;
        dataEntrada = "10/11/2023";

        Receita receita2 = new Receita(id, idfk, valorEntrada, dataEntrada);        
        System.out.println("Crie a segunda despesa " + receita2);

        receitaDAO.insert(receita2);

        // criando a terceira conta
        id = 3;
        idfk = 2;
        valorEntrada = 55.50;
        dataEntrada = "13/11/2023";

        Receita receita3 = new Receita(id, idfk, valorEntrada, dataEntrada); 
        System.out.println("Crie a terceira despesa " + receita3);

        receitaDAO.insert(receita3);

        // criando a quarta conta
        id = 4;
        idfk = 2;
        valorEntrada = 55.50;
        dataEntrada = "13/11/2023";

        Receita receita4 = new Receita(id, idfk, valorEntrada, dataEntrada); 
        System.out.println("Crie a quarta despesa " + receita4);

        receitaDAO.insert(receita4);

        // criando a quinta conta
        id = 5;
        idfk = 2;
        valorEntrada = 55.50;
        dataEntrada = "13/11/2023";
        
        Receita receita5 = new Receita(id, idfk, valorEntrada, dataEntrada); 
        System.out.println("Crie a quinta despesa " + receita5);

        receitaDAO.insert(receita5);


        //print pessoa;
        System.out.println("imprimindo todas as despesa");
        receitaDAO.getAll().forEach(System.out::println);

        //print pessoa encontada
        System.out.println(receitaDAO.getById(1));

        //deleta pessoa
        receitaDAO.deleteById(4);

        //atualizaçao pessoa
        valorEntrada = 6.00;

        receitaDAO.updateById(5, valorEntrada);

        //verifica opcao deletada e atualizada
        receitaDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        receitaDAO.deleteById(6);

        //atualiza pessoa que nao existe
        receitaDAO.updateById(6, valorEntrada);

        //seleciona pessoa que nao existe
        receitaDAO.getById(6);
    }
	
}
