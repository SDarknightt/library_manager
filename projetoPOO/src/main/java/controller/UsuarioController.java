package controller;

import dao.LivroDAO;
import model.Usuario;
import service.LoginService;
import service.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/usuariocontroller")
public class UsuarioController extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {


        String acao = req.getParameter("acao");

        if (acao.equals("cadastrarusuario")) {
            String nome = req.getParameter("nomeusuario");
            String cpf = req.getParameter("cpfusuario");
            String login = req.getParameter("login");
            String senha = req.getParameter("senha");
            System.out.println(nome + " - " + cpf + " - " + login + " - " + senha);

            RequestDispatcher dispatcher;

            UsuarioService usuarioService = new UsuarioService();

            if (usuarioService.verificarLoginExistente(login)) {
                System.out.println("Usuário já cadastrado!");
                dispatcher = req.getRequestDispatcher("/index.jsp");
            } else {
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                usuario.setCpf(cpf);
                usuario.setLogin(login);
                usuario.setSenha(senha);

                boolean cadastrado = usuarioService.cadastrarUsuario(usuario);

                if (cadastrado) {
                    System.out.println("Usuário cadastrado com sucesso!");
                    dispatcher = req.getRequestDispatcher("principal.jsp");
                } else {
                    System.out.println("Falha ao cadastrar usuário!");
                    dispatcher = req.getRequestDispatcher("index.jsp");
                }
            }

            dispatcher.forward(req, resp);
        }


        else if (acao.equals("fazerlogin")) {

            String login = req.getParameter("login");//name do input no index
            String senha = req.getParameter("senha");//name do input no index

            System.out.println(login + " - " + senha);

            RequestDispatcher dispatcher;

            if (new LoginService().autenticar(login, senha)) {
                dispatcher = req.getRequestDispatcher("/principal.jsp");

            } else {
                dispatcher = req.getRequestDispatcher("/index.jsp");
            }
            dispatcher.forward(req, resp);
        }
    }
}
