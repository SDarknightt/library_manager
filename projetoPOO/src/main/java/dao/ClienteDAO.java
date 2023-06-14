package dao;

import model.Cliente;
import model.Livro;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO {//aqui será feito o CRUD

    public ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try(Connection con = new ConectaDB().getConexao()){

            String sql = "SELECT * " +
                    "FROM cliente ORDER BY idcliente";

            PreparedStatement pt = con.prepareStatement(sql);
            //pt.setString(1, login);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                clientes.add(new Cliente(
                        rs.getInt("idcliente"),
                        rs.getString("nomecliente"),
                        rs.getString("cpfcliente")
                ));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return clientes;
    }


    public boolean verificarClienteExistente(String cpf) {
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT COUNT(*) FROM cliente WHERE cpfcliente = ?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, cpf);
            System.out.println(pt);
            ResultSet rs = pt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if(count > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public void adicionarCliente(Cliente cliente) {
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "INSERT INTO cliente (nomecliente, cpfcliente) VALUES (?, ?)";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, cliente.getNome());
            pt.setString(2, cliente.getCpf());

            pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
