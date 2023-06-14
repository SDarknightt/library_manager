package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

    public boolean verificarLoginExistente(String login) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.verificarLoginExistente(login);
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Verificar se o login já está em uso
        boolean loginExistente = verificarLoginExistente(usuario.getLogin());
        if (loginExistente) {
            System.out.println("Login já está em uso: " + usuario.getLogin());
            return false;
        }

        // Adicionar o usuário no banco de dados
        usuarioDAO.adicionarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso: " + usuario.getLogin());
        return true;
    }


}
