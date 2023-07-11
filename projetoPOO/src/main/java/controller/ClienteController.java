package controller;

import dao.ClienteDAO;
import dao.LivroDAO;
import model.Cliente;
import model.Livro;
import service.ClienteService;
import service.LivroService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/clientecontroller")
public class ClienteController extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");
        RequestDispatcher dispatcher;

        if (acao.equals("cadastrarcliente")) {
            String nome = req.getParameter("nomecliente");
            String cpf = req.getParameter("cpfcliente");
            System.out.println(nome + " - " + cpf);


            ClienteService clienteService = new ClienteService();

            if (clienteService.verificarClienteExistente(cpf)) {
                System.out.println("Cliente já cadastrado!");
                dispatcher = req.getRequestDispatcher("/clientes.jsp");
            } else {
                Cliente cliente = new Cliente();
                cliente.setNome(nome);
                cliente.setCpf(cpf);

                boolean cadastrado = clienteService.cadastrarCliente(cliente);

                if (cadastrado) {
                    System.out.println("Cliente cadastrado com sucesso!");
                    dispatcher = req.getRequestDispatcher("clientes.jsp");
                } else {
                    System.out.println("Falha ao cadastrar cliente!");
                    dispatcher = req.getRequestDispatcher("/index.jsp");
                }
            }

            dispatcher.forward(req, resp);
        } else if (acao.equals("deletarcliente")) {
            String id = req.getParameter("idcliente");

            ClienteService clienteService = new ClienteService();


            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(id));

            boolean deletado = clienteService.deletarCliente(cliente);
            if (deletado) {
                System.out.println("Livro deletado com sucesso!");
                dispatcher = req.getRequestDispatcher("clientes.jsp");
            } else {
                System.out.println("Falha ao deletar livro!");
                dispatcher = req.getRequestDispatcher("principal.jsp");
            }

            dispatcher.forward(req, resp);
        } else if (acao.equals("editarcliente")){
            String id = req.getParameter("idcliente");
            String nome = req.getParameter("nomecliente");
            String cpf = req.getParameter("cpfcliente");

            ClienteService clienteService = new ClienteService();
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(id));
            cliente.setNome(nome);
            cliente.setCpf(cpf);

            boolean editado = clienteService.editarCliente(cliente);
            if (editado) {
                System.out.println("Livro editar com sucesso!");
                dispatcher = req.getRequestDispatcher("clientes.jsp");
            } else {
                System.out.println("Falha ao editar livro!");
                dispatcher = req.getRequestDispatcher("principal.jsp");
            }
            dispatcher.forward(req, resp);
        }

        else if (acao.equals("selecionacliente")){
            int id = Integer.parseInt(req.getParameter("idcliente"));

            if (req.getAttribute("cliente") == null) {
                req.setAttribute("cliente", new ClienteDAO().getCliente(id));
            }
            dispatcher = req.getRequestDispatcher("/editarcliente.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
