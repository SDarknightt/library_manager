package controller;

import dao.LivroDAO;
import dao.ReservaDAO;
import model.Reserva;
import service.ReservaService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/reservacontroller")
public class ReservaController extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        if (acao.equals("devolverlivro")) {
            Reserva reservaaux = new Reserva();
            reservaaux.setLivroid(Integer.parseInt(req.getParameter("idlivro")));
            reservaaux.setClienteid(Integer.parseInt(req.getParameter("idcliente")));

            String idReserva = req.getParameter("idreserva");
            System.out.println("ID da Reserva para devolução: " + idReserva);

            ReservaService reservaService = new ReservaService();
            boolean devolvido = reservaService.devolverLivro(reservaaux);

            if (devolvido) {
                System.out.println("Livro devolvido com sucesso!");
            } else {
                System.out.println("Falha ao devolver livro!");
            }

            RequestDispatcher dispatcher = req.getRequestDispatcher("reservas.jsp");
            dispatcher.forward(req, resp);
        }

        else if(acao.equals("reservarlivro")) {
            String idlivro = req.getParameter("idlivro");
            String idcliente = req.getParameter("idcliente");
            System.out.println("ID do Livro: " + idlivro + ", ID do Cliente: " + idcliente);

            RequestDispatcher dispatcher;

            ReservaService reservaService = new ReservaService();
            Reserva reserva = new Reserva();
            reserva.setLivroid(Integer.parseInt(idlivro));
            reserva.setClienteid(Integer.parseInt(idcliente));

            boolean cadastrado = reservaService.cadastrarReserva(reserva);

            if (cadastrado) {
                System.out.println("Reserva efetuada com sucesso!");
                dispatcher = req.getRequestDispatcher("reservas.jsp");
            } else {
                System.out.println("Falha ao efetuar reserva!");
                dispatcher = req.getRequestDispatcher("principal.jsp");
            }

            dispatcher.forward(req, resp);
        }
        else if (acao.equals("visualizar")){
            RequestDispatcher dispatcher;

            if (req.getAttribute("reservas") == null) {
                req.setAttribute("reservas", new ReservaDAO().getReservas());
            }
            dispatcher = req.getRequestDispatcher("/visualizarreservas.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
