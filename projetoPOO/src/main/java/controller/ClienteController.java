package controller;

import dao.ClienteDAO;
import dao.LivroDAO;
import model.Cliente;
import service.ClienteService;

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
        }

        else if (acao.equals("visualizar")){
            if (req.getAttribute("clientes") == null) {
                req.setAttribute("clientes", new ClienteDAO().getClientes());
            }
            dispatcher = req.getRequestDispatcher("/visualizarclientes.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
