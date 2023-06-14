package dao;

import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    /*public Usuario getUsuario(String login){
        //select * from usuario where login = login
        return new Usuario(1,"Samuel", "000.000.000-00", "Samuel", "1234");
    }*/

    public Usuario getUsuario(String login){
        Usuario usuario = new Usuario();
        try(Connection con = new ConectaDB().getConexao()){

            String sql = "SELECT * " +
                    "FROM usuario WHERE login = ?";

            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, login);
            System.out.println("sql: "+pt.toString());
            ResultSet rs = pt.executeQuery();

            while (rs.next()){
                usuario.setId(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nomeusuario"));
                usuario.setCpf(rs.getString("cpfusuario"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Nome do usuario: "+usuario.getNome());

        return usuario;
    }

    public boolean verificarLoginExistente(String login) {
            boolean loginExistente = false;
            try (Connection con = new ConectaDB().getConexao()) {
                String sql = "SELECT COUNT(*) FROM usuario WHERE login = ?";
                PreparedStatement pt = con.prepareStatement(sql);
                pt.setString(1, login);
                ResultSet rs = pt.executeQuery();
                if (rs.next()) {
                    int count = rs.getInt(1);
                    loginExistente = count > 0;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return loginExistente;
    }

    public void adicionarUsuario(Usuario usuario) {
            try (Connection con = new ConectaDB().getConexao()) {
                String sql = "INSERT INTO usuario (nomeusuario, cpfusuario, login, senha) VALUES (?, ?, ?, ?)";

                PreparedStatement pt = con.prepareStatement(sql);
                pt.setString(1, usuario.getNome());
                pt.setString(2, usuario.getCpf());
                pt.setString(3, usuario.getLogin());
                pt.setString(4, usuario.getSenha());

                pt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
