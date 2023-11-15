package sem.dominio;

import sem.dominio.dao.TelefoneDAO;
import sem.dominio.entity.Telefone;
import sem.dominio.factory.DAOFactory;

public class IniciarTelefone  {
	
	public void iniciar() {

        // criando a primeira despesa
        int id = 1;
        int idfk = 1;
        String ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone;
        ddiDoNumero = "+55";
        dddDoNumero = "77";
        numeroTelefonico = "965856213";
        tipoDoTelefone = "residencial";

        Telefone despesa1 = new Telefone(id, idfk, ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone);
        System.out.println("Crie a primeira despesa " + despesa1);

        TelefoneDAO despesaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTelefoneDAO();

        despesaDAO.insert(despesa1);

        // criando a segunda conta
        id = 2;
        idfk = 2;
        ddiDoNumero = "+55";
        dddDoNumero = "77";
        numeroTelefonico = "965856213";
        tipoDoTelefone = "residencial";

        Telefone despesa2 = new Telefone(id, idfk, ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone);        
        System.out.println("Crie a segunda despesa " + despesa2);

        despesaDAO.insert(despesa2);

        // criando a terceira conta
        id = 3;
        idfk = 2;
        ddiDoNumero = "+55";
        dddDoNumero = "77";
        numeroTelefonico = "965856213";
        tipoDoTelefone = "residencial";

        Telefone despesa3 = new Telefone(id, idfk, ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone); 
        System.out.println("Crie a terceira despesa " + despesa3);

        despesaDAO.insert(despesa3);

        // criando a quarta conta
        id = 4;
        idfk = 2;
        ddiDoNumero = "+55";
        dddDoNumero = "77";
        numeroTelefonico = "965856213";
        tipoDoTelefone = "residencial";

        Telefone despesa4 = new Telefone(id, idfk, ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone); 
        System.out.println("Crie a quarta despesa " + despesa4);

        despesaDAO.insert(despesa4);

        // criando a quinta conta
        id = 5;
        idfk = 2;
        ddiDoNumero = "+55";
        dddDoNumero = "77";
        numeroTelefonico = "965856213";
        tipoDoTelefone = "residencial";
        
        Telefone despesa5 = new Telefone(id, idfk, ddiDoNumero, dddDoNumero, numeroTelefonico, tipoDoTelefone); 
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

        //despesaDAO.updateById(5, valorDespesa);

        //verifica opcao deletada e atualizada
        despesaDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        despesaDAO.deleteById(6);

        //atualiza pessoa que nao existe
        //despesaDAO.updateById(6, valorDespesa);

        //seleciona pessoa que nao existe
        despesaDAO.getById(6);
    }
	
}
