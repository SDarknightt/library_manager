
package service;

import dao.ReservaDAO;
import model.Reserva;

import java.util.List;

public class ReservaService {

    private ReservaDAO reservaDAO;

    public ReservaService() {
        this.reservaDAO = new ReservaDAO();
    }


    /*---------> Cadastrar Reserva<---------*/
    public boolean cadastrarReserva(Reserva reserva) {
        ReservaDAO reservaDAO = new ReservaDAO();
        // Adicionar a reserva no banco de dados
        reservaDAO.adicionarReserva(reserva);
        System.out.println("Reserva cadastrada com sucesso: Livro -" + reserva.getLivroid() + "Cliente -" + reserva.getClienteid());
        return true;
    }

    public boolean devolverLivro(Reserva reserva) {
        ReservaDAO reservaDAO = new ReservaDAO();
        // Adicionar a reserva no banco de dados
        reservaDAO.cancelarReserva(reserva);
        System.out.println("Reserva cancelada com sucesso: Livro -" + reserva.getLivroid() + "Cliente -" + reserva.getClienteid());
        return true;
    }

}
