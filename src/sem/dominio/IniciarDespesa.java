package sem.dominio;

import sem.dominio.dao.DespesaDAO;
import sem.dominio.entity.Despesa;
import sem.dominio.factory.DAOFactory;

public class IniciarDespesa {

	public void iniciar() {

        // criando a primeira despesa
        int id = 1;
        int idfk = 1;
        double valorDespesa = 550.50;
        String dataDespesa = "11/09/2023";

        Despesa despesa1 = new Despesa(id, idfk, valorDespesa, dataDespesa);
        System.out.println("Crie a primeira despesa " + despesa1);

        DespesaDAO despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getDespesaDAO();

        despesaDAO.insert(despesa1);

        // criando a segunda conta
        id = 2;
        idfk = 2;
        valorDespesa = 55.50;
        dataDespesa = "10/11/2023";

        Despesa despesa2 = new Despesa(id, idfk, valorDespesa, dataDespesa);        
        System.out.println("Crie a segunda despesa " + despesa2);

        despesaDAO.insert(despesa2);

        // criando a terceira conta
        id = 3;
        idfk = 2;
        valorDespesa = 55.50;
        dataDespesa = "13/11/2023";

        Despesa despesa3 = new Despesa(id, idfk, valorDespesa, dataDespesa); 
        System.out.println("Crie a terceira despesa " + despesa3);

        despesaDAO.insert(despesa3);

        // criando a quarta conta
        id = 4;
        idfk = 2;
        valorDespesa = 55.50;
        dataDespesa = "13/11/2023";

        Despesa despesa4 = new Despesa(id, idfk, valorDespesa, dataDespesa); 
        System.out.println("Crie a quarta despesa " + despesa4);

        despesaDAO.insert(despesa4);

        // criando a quinta conta
        id = 5;
        idfk = 2;
        valorDespesa = 55.50;
        dataDespesa = "13/11/2023";
        
        Despesa despesa5 = new Despesa(id, idfk, valorDespesa, dataDespesa); 
        System.out.println("Crie a quinta despesa " + despesa5);

        despesaDAO.insert(despesa5);


        //print pessoa;
        System.out.println("imprimindo todas as despesa");
        despesaDAO.getAll().forEach(System.out::println);

        //print pessoa encontada
        System.out.println(despesaDAO.getById(1));

        //deleta pessoa
        despesaDAO.deleteById(4);

        //atualizaçao pessoa
        valorDespesa = 6.00;

        despesaDAO.updateById(5, valorDespesa);

        //verifica opcao deletada e atualizada
        despesaDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        despesaDAO.deleteById(6);

        //atualiza pessoa que nao existe
        despesaDAO.updateById(6, valorDespesa);

        //seleciona pessoa que nao existe
        despesaDAO.getById(6);
    }
	
}
