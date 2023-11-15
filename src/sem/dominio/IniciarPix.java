package sem.dominio;

import sem.dominio.dao.PixDAO;
import sem.dominio.entity.Pix;
import sem.dominio.factory.DAOFactory;

public class IniciarPix {
	
	public void iniciar() {

        // criando a primeira despesa
        int id = 1;
        int idfk = 1;
        int quantidadeTransacao = 3;
        String chavePix = "seuemail@nossoemail.com";
        double limiteTransacao = 1550.50;

        Pix pix1 = new Pix(id, idfk, chavePix, limiteTransacao, quantidadeTransacao);
        System.out.println("Crie o primeiro pix " + pix1);

        PixDAO pixDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getPixDAO();

        pixDAO.insert(pix1);

        // criando a segunda conta
        id = 2;
        idfk = 2;
        quantidadeTransacao = 5;
        chavePix = "+5577980130297";
        limiteTransacao = 5000.00;

        Pix pix2 = new Pix(id, idfk, chavePix, limiteTransacao, quantidadeTransacao);        
        System.out.println("Crie a segunda despesa " + pix2);

        pixDAO.insert(pix2);

        // criando a terceira conta
        id = 3;
        idfk = 2;
        quantidadeTransacao = 5;
        chavePix = "+5577980130297";
        limiteTransacao = 5000.00;

        Pix pix3 = new Pix(id, idfk, chavePix, limiteTransacao, quantidadeTransacao);
        System.out.println("Crie a terceira despesa " + pix3);

        pixDAO.insert(pix3);

        // criando a quarta conta
        id = 4;
        idfk = 2;
        quantidadeTransacao = 5;
        chavePix = "+5577980130297";
        limiteTransacao = 5000.00;

        Pix pix4 = new Pix(id, idfk, chavePix, limiteTransacao, quantidadeTransacao);
        System.out.println("Crie a quarta despesa " + pix4);

        pixDAO.insert(pix4);

        // criando a quinta conta
        id = 5;
        idfk = 2;
        quantidadeTransacao = 5;
        chavePix = "+5577980130297";
        limiteTransacao = 5000.00;
        
        Pix pix5 = new Pix(id, idfk, chavePix, limiteTransacao, quantidadeTransacao);
        System.out.println("Crie a quinta despesa " + pix5);

        pixDAO.insert(pix5);


        //print pessoa;
        System.out.println("imprimindo todas as cahves pix");
        pixDAO.getAll().forEach(System.out::println);

        //print pessoa encontada
        System.out.println(pixDAO.getById(1));

        //deleta pessoa
        pixDAO.deleteById(4);

        //atualizaçao pessoa
        quantidadeTransacao = 12;
        limiteTransacao = 6000.00;
        pixDAO.updateById(5,limiteTransacao, quantidadeTransacao);

        //verifica opcao deletada e atualizada
        pixDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        pixDAO.deleteById(6);

        //atualiza pessoa que nao existe
        pixDAO.updateById(6, limiteTransacao, quantidadeTransacao);

        //seleciona pessoa que nao existe
        pixDAO.getById(6);
    }
	
}
