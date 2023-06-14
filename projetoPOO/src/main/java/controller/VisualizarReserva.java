package controller;

import dao.ClienteDAO;
import dao.ReservaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/direcionareserva.jsp")
public class VisualizarReserva extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;

        if (req.getAttribute("reservas") == null) {
            req.setAttribute("reservas", new ReservaDAO().getReservas());
        }
        dispatcher = req.getRequestDispatcher("/visualizarreservas.jsp");
        dispatcher.forward(req, resp);
    }
}

