package sem.dominio;

import sem.dominio.dao.PessoaDAO;
import sem.dominio.entity.Pessoa;
import sem.dominio.factory.DAOFactory;

public class IniciarPessoa {
	
	public void iniciar() {

        String nome, email, numeroCpfCnpj, sobrenome = null, dataNascimento;
        nome = "lindaval";
        email = "lindaval@email.com";
        numeroCpfCnpj = "12345678910";
        sobrenome = "oliveira";
        dataNascimento = "11/09/1990";

        Pessoa pessoa1 = new Pessoa(nome, email, dataNascimento, numeroCpfCnpj, sobrenome);
        System.out.println("Crie a primeira pessoa " + pessoa1);

        PessoaDAO pessoaDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getPessoaDAO();

        pessoaDAO.insert(pessoa1);

        nome = "lindaval";
        email = "lindaval@email.com";
        numeroCpfCnpj = "12345678910";
        sobrenome = "oliveira";
        dataNascimento = "11/09/1990";

        Pessoa pessoa2 = new Pessoa(nome, email, dataNascimento, numeroCpfCnpj, sobrenome);       
        System.out.println("Crie a segunda pessoa " + pessoa2);

        pessoaDAO.insert(pessoa2);

        nome = "lindaval";
        email = "lindaval@email.com";
        numeroCpfCnpj = "12345678910";
        sobrenome = "oliveira";
        dataNascimento = "11/09/1990";

        Pessoa pessoa3 = new Pessoa(nome, email, dataNascimento, numeroCpfCnpj, sobrenome);
        System.out.println("Crie a terceira pessoa " + pessoa3);

        pessoaDAO.insert(pessoa3);

        nome = "lindaval";
        email = "lindaval@email.com";
        numeroCpfCnpj = "12345677910";
        sobrenome = "oliveira";
        dataNascimento = "11/09/1990";

        Pessoa pessoa4 = new Pessoa(nome, email, dataNascimento, numeroCpfCnpj, sobrenome);
        System.out.println("Crie a quarta pessoa " + pessoa4);

        pessoaDAO.insert(pessoa4);

        nome = "lindaval";
        email = "lindaval@email.com";
        numeroCpfCnpj = "12345578910";
        sobrenome = "oliveira";
        dataNascimento = "11/09/1990";
        
        Pessoa pessoa5 = new Pessoa(nome, email, dataNascimento, numeroCpfCnpj, sobrenome); 
        System.out.println("Crie a quinta pessoa " + pessoa5);

        pessoaDAO.insert(pessoa5);


        //print pessoa;
        System.out.println("imprimindo todas as pessoa");
        pessoaDAO.getAll().forEach(System.out::println);

        //print pessoa encontada
        System.out.println(pessoaDAO.getById(1));

        //deleta pessoa
        pessoaDAO.deleteById(4);

        //atualizaçao pessoa
        email = "liti@meuemail.com";

        pessoaDAO.updateById(5, email);

        //verifica opcao deletada e atualizada
        pessoaDAO.getAll().forEach(System.out::println);

        //deleta pessoa pessoa nao existe
        pessoaDAO.deleteById(6);

        //atualiza pessoa que nao existe
        pessoaDAO.updateById(6, email);

        //seleciona pessoa que nao existe
        pessoaDAO.getById(6);
	}
}
