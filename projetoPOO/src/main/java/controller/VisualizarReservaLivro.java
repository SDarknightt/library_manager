package controller;

import dao.ClienteDAO;
import dao.LivroDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/direcionareservarlivro.jsp")
public class VisualizarReservaLivro extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        if (req.getAttribute("clientes") == null) {
            req.setAttribute("clientes", new ClienteDAO().getClientes());
        }
        if (req.getAttribute("livros") == null) {
            req.setAttribute("livros", new LivroDAO().getLivros());
        }
        dispatcher = req.getRequestDispatcher("/reservarlivro.jsp");
        dispatcher.forward(req, resp);
    }
}

