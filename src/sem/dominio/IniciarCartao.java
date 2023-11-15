package sem.dominio;

import sem.dominio.dao.CartaoDAO;
import sem.dominio.entity.Cartao;
import sem.dominio.factory.DAOFactory;

public class IniciarCartao {
    
    public void iniciar() {

        // adicionando primeira cartao
        int id = 1;
        int idconta = 1;
        String numero = "1234567890123456";
        String cvv = "701";
        String nome = "luis antonio da silva";
        String senha = "2033";
        String vencimento = "12/05/2030";
        double limite = 0;

        Cartao cartao1 = new Cartao(id, idconta, numero, cvv, nome, senha, vencimento, limite);
        System.out.println("Crie o primeiro cartão " + cartao1);

        CartaoDAO cartaoDao = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getCartaoDAO();

        cartaoDao.insert(cartao1);

        // adicionando segunda cartao
        id = 2;
        idconta = 2;
        numero = "1235567890133456";
        cvv = "721";
        nome = "breno";
        senha = "1073";
        vencimento = "07/05/2045";
        limite = 2000.00;

        Cartao cartao2 = new Cartao(id, idconta, numero, cvv, nome, senha, vencimento, limite);
        System.out.println("Crie a segundo Cartão " + cartao2);

        cartaoDao.insert(cartao2);

        // adicionando terceira cartao
        id = 3;
        idconta = 3;
        numero = "1275567890133456";
        cvv = "921";
        nome = "lucas c. santos";
        senha = "4564";
        vencimento = "08/12/2025";
        limite = 500.00;

        Cartao cartao3 = new Cartao(id, idconta, numero, cvv, nome, senha, vencimento, limite);
        System.out.println("Crie o terceiro cartao " + cartao3);

        cartaoDao.insert(cartao3);

        // adicionando quarta cartao
        id = 4;
        idconta = 4;
        numero = "4275567890133456";
        cvv = "975";
        nome = "laerte da silva alcantra";
        senha = "9693";
        vencimento = "10/06/2028";
        limite = 4100.00;

        Cartao cartao4 = new Cartao(id, idconta, numero, cvv, nome, senha, vencimento, limite);
        System.out.println("Crie o quarto cartao " + cartao4);

        cartaoDao.insert(cartao4);

        // adicionando quinto cartao
        id = 5;
        idconta = 5;
        numero = "4275567890233456";
        cvv = "075";
        nome = "luciano de almeida";
        senha = "4561";
        vencimento = "22/04/2027";
        limite = 3700.00;

        Cartao cartao5 = new Cartao(id, idconta, numero, cvv, nome, senha, vencimento, limite);
        System.out.println("Crie o quinto cartao " + cartao5);

        cartaoDao.insert(cartao5);


        //print todos os cartoes;
        System.out.println("imprimindo todas os cartoes");
        cartaoDao.getAll().forEach(System.out::println);

        //print cartao encontada
        System.out.println(cartaoDao.getById(1));

        //deleta cartao
        cartaoDao.deleteById(4);

        //atualizaçao cartao
        senha = "4599";
        limite = 1000.00;

        cartaoDao.updateById(5, senha, limite);

        //verifica opcao deletada e atualizada
        cartaoDao.getAll().forEach(System.out::println);

        //deleta  cartao nao existe
        cartaoDao.deleteById(6);

        //atualiza cartao que nao existe
        cartaoDao.updateById(6, senha, limite);

        //seleciona cartao que nao existe
        cartaoDao.getById(6);
    }
}
