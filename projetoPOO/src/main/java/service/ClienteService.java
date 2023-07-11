
package service;

import dao.ClienteDAO;
import dao.LivroDAO;
import model.Cliente;
import model.Livro;

public class ClienteService {

    /*---------> Cadastrar Cliente<---------*/
    public boolean cadastrarCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();

        // Verificar se o login já está em uso
        boolean clienteExistente = verificarClienteExistente(cliente.getCpf());
        if (clienteExistente) {
            System.out.println("Cliente já está cadastrado: " + cliente.getCpf());
            return false;
        }

        // Adicionar o usuário no banco de dados
        clienteDAO.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso: " + cliente.getNome());
        return true;
    }

    public boolean verificarClienteExistente(String cpf) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.verificarClienteExistente(cpf);
    }
    public boolean deletarCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        // Deleta o livro do banco de dados
        clienteDAO.deletarCliente(cliente);
        System.out.println("Livro delatado com sucesso: " + cliente.getNome());
        return true;
    }

    public boolean editarCliente(Cliente cliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        // Edita o cliente do banco de dados
        clienteDAO.editarCliente(cliente);
        System.out.println("Cliente editado com sucesso: " + cliente.getNome());
        return true;
    }}
