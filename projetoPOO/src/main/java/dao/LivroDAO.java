package dao;

import model.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {//aqui será feito o CRUD
    /* public boolean verificarLivroExistente(String cpf) {
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "SELECT COUNT(*) FROM cliente WHERE cpf = ?";
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
*/


    public void adicionarLivro(Livro livro) {
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "INSERT INTO livro (nomelivro, genero) VALUES (?, ?)";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, livro.getNome());
            pt.setString(2, livro.getGenero());

            pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deletarLivro(Livro livro) {
        try (Connection con = new ConectaDB().getConexao()) {
            String sql = "DELETE FROM livro WHERE idlivro = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setInt(1, livro.getId());
            pt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public ArrayList<Livro> getLivros(){
        ArrayList<Livro> livros = new ArrayList<>();
        try(Connection con = new ConectaDB().getConexao()){

            String sql = "SELECT * " +
                    "FROM livro ORDER BY idlivro";

            PreparedStatement pt = con.prepareStatement(sql);
            //pt.setString(1, login);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                livros.add(new Livro(
                                    rs.getInt("idlivro"),
                                    rs.getString("nomelivro"),
                                    rs.getString("genero"),
                                    rs.getBoolean("reservado")
                                    ));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return livros;
    }

    public Livro getLivro(String nomelivro){
        Livro livro = new Livro();
        try(Connection con = new ConectaDB().getConexao()){

            String sql = "SELECT * " +
                    "FROM livro WHERE nomelivro = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, nomelivro);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                livro.setId(rs.getInt("idlivro"));
                livro.setNome(rs.getString("nomelivro"));
                livro.setGenero(rs.getString("genero"));
                livro.setRetirado(rs.getBoolean("reservado"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Nome do livro: "+livro.getNome());

        return livro;
    }


}
