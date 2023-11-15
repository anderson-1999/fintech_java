package sem.dominio;

import sem.dominio.dao.EnderecoDAO;
import sem.dominio.entity.Endereco;
import sem.dominio.factory.DAOFactory;

public class IniciarEndereco {
	
	public void iniciar() {

        // criando a primeira conta
        int id = 1;
        int idfk = 1;
        String cep = "44256000";
        String barrio = "luccia";
        String tipoLogradouro = "avenida";
        String nomeLogradouro = "isolinda carneiro";
        String complemento = null;
        String numero = "153";
        String tipoResidencia = "Residencial";

        Endereco endereco1 = new Endereco(id, idfk, cep, barrio, tipoLogradouro, nomeLogradouro, complemento, numero, tipoResidencia);
        System.out.println("Crie o primeiro endereço " + endereco1);

        EnderecoDAO enderecoDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getEnderecoDAO();

        enderecoDAO.insert(endereco1);

        // criando a segunda conta
        id = 2;
        idfk = 2;
        tipoLogradouro = "rua";
        cep = "02132000";
        barrio = "centro";
        nomeLogradouro = "luis estaquio";
        complemento = "casa 2";
        numero = "5525";
        tipoResidencia ="residecial";

        Endereco endereco2 = new Endereco(id, idfk, cep, barrio, tipoLogradouro, nomeLogradouro,
        		complemento, numero, tipoResidencia);
        System.out.println("Crie o segundo endereço " + endereco2);

        enderecoDAO.insert(endereco2);

        // criando a terceira conta
        id = 3;
        idfk = 3;
        tipoLogradouro = "rua";
        cep = "50213000";
        barrio = "centro";
        nomeLogradouro = "tanha da luz";
        complemento = null;
        numero = "5";
        tipoResidencia = "residencial";

        Endereco endereco3 = new Endereco(id, idfk, cep, barrio, tipoLogradouro, nomeLogradouro, complemento, numero, tipoResidencia);
        System.out.println("Crie o terceiro endereço " + endereco3);

        enderecoDAO.insert(endereco3);

        // criando a quarta conta
        id = 4;
        idfk = 4;
        tipoLogradouro = "rua";
        cep = "12345000";
        barrio = "centro";
        nomeLogradouro = "rua consolação";
        complemento = null;
        numero = "64";
        tipoResidencia = "Empresarial";

        Endereco endereco4 = new Endereco(id, idfk, cep, barrio, tipoLogradouro, nomeLogradouro, complemento, numero, tipoResidencia);
        System.out.println("Crie o quarto endereço " + endereco4);

        enderecoDAO.insert(endereco4);

        // criando a quinta conta
        id = 5;
        idfk = 5;
        tipoLogradouro = "rua";
        cep = "01365000";
        barrio = "cambucci";
        nomeLogradouro ="luciano rosa";
        complemento = null;
        numero = "1232";
        tipoResidencia = "empresarial";
        
        Endereco endereco5 = new Endereco(id, idfk, cep, barrio, tipoLogradouro, nomeLogradouro, complemento, numero, tipoResidencia);
        System.out.println("Crie o quinto endereço " + endereco5);

        enderecoDAO.insert(endereco5);


        //print endereço;
        System.out.println("imprimindo todos os endereços");
        enderecoDAO.getAll().forEach(System.out::println);

        //print endereço encontada
        System.out.println(enderecoDAO.getById(1));

        //deleta endereço
        enderecoDAO.deleteById(4);

        //atualizaçao endereço
        
        tipoResidencia = "residecial";

        //contaDAO.updateById(5, null, null, null, null, limiteCredito);

        //verifica opcao deletada e atualizada
        enderecoDAO.getAll().forEach(System.out::println);

        //deleta endereço nao existe
        enderecoDAO.deleteById(6);

        //atualiza endereço que nao existe
        //contaDAO.updateById(6, null, null, null, null, limiteCredito);

        //seleciona endereço que nao existe
        enderecoDAO.getById(6);
    }
	
}
