package dao;

import model.Reserva;
import model.ReservaLivro;

import java.sql.*;
import java.util.ArrayList;

public class ReservaDAO {

    public void adicionarReserva(Reserva reserva) {
        try (Connection con = new ConectaDB().getConexao()) {
            //efetua a reserva
            String sql = "INSERT INTO reserva_livro (clienteid, livroid) VALUES (?, ?)";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, reserva.getClienteid());
            pt.setInt(2, reserva.getLivroid());
            pt.executeUpdate();

            //reserva o livro
            String sql2 = "UPDATE livro SET reservado = true WHERE idlivro = ?;";
            PreparedStatement pt2 = con.prepareStatement(sql2);
            pt2.setInt(1, reserva.getLivroid());
            pt2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelarReserva(Reserva reserva) {
        try (Connection con = new ConectaDB().getConexao()) {
            //deleta a reserva
            String sql = "DELETE FROM reserva_livro WHERE clienteid = ? AND livroid = ?;\n";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, reserva.getClienteid());
            pt.setInt(2, reserva.getLivroid());
            pt.executeUpdate();

            //libera o livro
            String sql2 = "UPDATE livro SET reservado = false WHERE idlivro = ?;";
            PreparedStatement pt2 = con.prepareStatement(sql2);
            pt2.setInt(1, reserva.getLivroid());
            pt2.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ReservaLivro> getReservas(){
        ArrayList<ReservaLivro> reservas = new ArrayList<>();
        try(Connection con = new ConectaDB().getConexao()){
            /*String sql = "SELECT * " +
                    "FROM reserva ORDER BY id";*/
            String sql = "SELECT cliente.idcliente, cliente.nomecliente, livro.idlivro, livro.nomelivro " +
                    "FROM livro, cliente, reserva_livro " +
                    "WHERE cliente.idcliente = reserva_livro.clienteid " +
                    "AND livro.idlivro = reserva_livro.livroid ORDER BY cliente.idcliente";

            PreparedStatement pt = con.prepareStatement(sql);
            //pt.setString(1, login);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                reservas.add(new ReservaLivro(
                        rs.getInt("idcliente"),
                        rs.getString("nomecliente"),
                        rs.getInt("idlivro"),
                        rs.getString("nomelivro")
                ));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return reservas;
    }
}
