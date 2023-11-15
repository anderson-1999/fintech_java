package sem.dominio;

import sem.dominio.dao.ContaDAO;
import sem.dominio.entity.Conta;
import sem.dominio.factory.DAOFactory;

public class IniciarConta {
	
	public void iniciar() {

        // criando a primeira conta
        int id = 1;
        int idPessoa = 1;
        double saldo = 550.50;
        String numeroAgencia = "1234";
        String numeroConta = "12345";
        double lisConta = 200.00;
        double seguroCartao = 0.0;
        double cestaProdutos = 0.0;
        double limiteCredito = 0.0;
        String senhaConta = "fult2905";

        Conta conta1 = new Conta(id, idPessoa, numeroAgencia, numeroConta, saldo, lisConta, seguroCartao, cestaProdutos, limiteCredito, senhaConta);
        System.out.println("Crie a primeira conta " + conta1);

        ContaDAO contaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getContaDAO();

        contaDAO.insert(conta1);

        // criando a segunda conta
        id = 2;
        idPessoa = 2;
        saldo = 150.50;
        numeroAgencia = "1234";
        numeroConta = "15345";
        lisConta = 200.00;
        seguroCartao = 0.0;
        cestaProdutos = 50.0;
        limiteCredito = 100.0;
        senhaConta = "Lpeixe2036";

        Conta conta2 = new Conta(id, idPessoa, numeroAgencia, numeroConta, saldo, lisConta, seguroCartao, cestaProdutos, limiteCredito, senhaConta);
        System.out.println("Crie a segunda conta " + conta2);

        contaDAO.insert(conta2);

        // criando a terceira conta
        id = 3;
        idPessoa = 3;
        saldo = 550.50;
        numeroAgencia = "2234";
        numeroConta = "12345";
        lisConta = 1000.00;
        seguroCartao = 0.0;
        cestaProdutos = 0.0;
        limiteCredito = 2000.0;
        senhaConta = "ynl69ast";

        Conta conta3 = new Conta(id, idPessoa, numeroAgencia, numeroConta, saldo, lisConta, seguroCartao, cestaProdutos, limiteCredito, senhaConta);
        System.out.println("Crie a terceira conta " + conta3);

        contaDAO.insert(conta3);

        // criando a quarta conta
        id = 4;
        idPessoa = 4;
        saldo = 123.56;
        numeroAgencia = "1235";
        numeroConta = "123451";
        lisConta = 200.00;
        seguroCartao = 0.0;
        cestaProdutos = 0.0;
        limiteCredito = 0.0;
        senhaConta = "P#berne";

        Conta conta4 = new Conta(id, idPessoa, numeroAgencia, numeroConta, saldo, lisConta, seguroCartao, cestaProdutos, limiteCredito, senhaConta);
        System.out.println("Crie a quarta pessoa " + conta4);

        contaDAO.insert(conta4);

        // criando a quinta conta
        id = 5;
        idPessoa = 5;
        saldo = 3550.50;
        numeroAgencia = "1534";
        numeroConta = "123457";
        lisConta = 200.00;
        seguroCartao = 0.0;
        cestaProdutos = 0.0;
        limiteCredito = 0.0;
        senhaConta = "+nao223portu#anota";
        Conta conta5 = new Conta(id, idPessoa, numeroAgencia, numeroConta, saldo, lisConta, seguroCartao, cestaProdutos, limiteCredito, senhaConta);
        System.out.println("Crie a quinta pessoa " + conta5);

        contaDAO.insert(conta5);


        //print pessoa;
        System.out.println("imprimindo todas as pessoas");
        contaDAO.getAll().forEach(System.out::println);

        //print pessoa encontada
        System.out.println(contaDAO.getById(1));

        //deleta pessoa
        contaDAO.deleteById(4);

        //atualizaçao pessoa
        senhaConta = "4599";
        limiteCredito = 1000.00;

        //contaDAO.updateById(5, senhaConta, null, null, null, null, limiteCredito);

        //verifica opcao deletada e atualizada
        contaDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        contaDAO.deleteById(6);

        //atualiza pessoa que nao existe
        //contaDAO.updateById(6, senhaConta, null, null, null, null, limiteCredito);

        //seleciona pessoa que nao existe
        contaDAO.getById(6);
    }
	
}
