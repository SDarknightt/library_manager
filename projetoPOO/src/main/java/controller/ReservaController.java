package controller;

import dao.LivroDAO;
import dao.ReservaDAO;
import model.Reserva;
import model.ReservaLivro;
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
        else if (acao.equals("selecionareserva")){
            int id = Integer.parseInt(req.getParameter("idreserva"));
            System.out.println("Entrou no seleciona Reserva --> ID: "+ id);
            RequestDispatcher dispatcher;

            if (req.getAttribute("livros") == null) {
                req.setAttribute("livros", new LivroDAO().getLivros());
            }
            req.setAttribute("editareserva", new ReservaDAO().getReserva(id));
            dispatcher = req.getRequestDispatcher("/editarreserva.jsp");
            dispatcher.forward(req, resp);
        }

        else if(acao.equals("editarreserva")) {
                Reserva reservaaux = new Reserva();
                reservaaux.setLivroid(Integer.parseInt(req.getParameter("idlivro")));
                reservaaux.setId(Integer.parseInt(req.getParameter("idreserva")));

                ReservaService reservaService = new ReservaService();
                boolean editado = reservaService.editarReserva(reservaaux);

                if (editado) {
                    System.out.println("Reserva editada com sucesso!");
                } else {
                    System.out.println("Falha ao editar reserva!");
                }

                RequestDispatcher dispatcher = req.getRequestDispatcher("reservas.jsp");
                dispatcher.forward(req, resp);
        }
    }
}
