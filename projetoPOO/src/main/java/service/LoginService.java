package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

    public boolean autenticar(String login, String senha){

        Usuario u = new UsuarioDAO().getUsuario(login);
        if(u.getLogin() == null){
            System.out.println("usuário null -> "+u.getLogin());
            return false;
        }else{
            if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
                return true;
            }else{
                return false;
            }
        }
    }
}
