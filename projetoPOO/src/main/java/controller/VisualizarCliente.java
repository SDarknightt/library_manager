package controller;

import dao.ClienteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/direcionacliente.jsp")
public class VisualizarCliente extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        if (req.getAttribute("clientes") == null) {
            req.setAttribute("clientes", new ClienteDAO().getClientes());
        }
        dispatcher = req.getRequestDispatcher("/visualizarclientes.jsp");
        dispatcher.forward(req, resp);
    }
}

