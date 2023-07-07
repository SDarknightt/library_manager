package controller;

import dao.LivroDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import model.Livro;
import service.LivroService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

@WebServlet("/livrocontroller")
public class LivroController extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        String acao = req.getParameter("acao");

        RequestDispatcher dispatcher;
        if (acao.equals("cadastrarlivro")) {
            String nome = req.getParameter("nomelivro");
            String genero = req.getParameter("generolivro");
            System.out.println(nome + " - " + genero);

            LivroService livroService = new LivroService();


            Livro livro = new Livro();
            livro.setNome(nome);
            livro.setGenero(genero);

            boolean cadastrado = livroService.cadastrarLivro(livro);
            if (cadastrado) {
                System.out.println("Livro cadastrado com sucesso!");
                dispatcher = req.getRequestDispatcher("livros.jsp");
            } else {
                System.out.println("Falha ao cadastrar livro!");
                dispatcher = req.getRequestDispatcher("principal.jsp");
            }

            dispatcher.forward(req, resp);
        }

        else if (acao.equals("deletarlivro")){
            String id = req.getParameter("idlivro");

            LivroService livroService = new LivroService();
            Livro livro = new Livro();
            livro.setId(Integer.parseInt(id));
            boolean deletado = livroService.deletarLivro(livro);
            if (deletado) {
                System.out.println("Livro deletado com sucesso!");
                dispatcher = req.getRequestDispatcher("livros.jsp");
            } else {
                System.out.println("Falha ao deletar livro!");
                dispatcher = req.getRequestDispatcher("principal.jsp");
            }

            dispatcher.forward(req, resp);
        }

        else if (acao.equals("editarlivro")){
            String id = req.getParameter("idlivro");
            String nomeLivro = req.getParameter("nomelivro");
            String genero = req.getParameter("genero");

            LivroService livroService = new LivroService();
            Livro livro = new Livro();
            livro.setId(Integer.parseInt(id));
            livro.setNome(nomeLivro);
            livro.setGenero(genero);

            boolean editado = livroService.editarLivro(livro);
            if (editado) {
                System.out.println("Livro editar com sucesso!");
                dispatcher = req.getRequestDispatcher("livros.jsp");
            } else {
                System.out.println("Falha ao editar livro!");
                dispatcher = req.getRequestDispatcher("principal.jsp");
            }
            dispatcher.forward(req, resp);
        }

        else if (acao.equals("selecionalivro")){
            int id = Integer.parseInt(req.getParameter("idlivro"));

            if (req.getAttribute("livro") == null) {
                req.setAttribute("livro", new LivroDAO().getLivro(id));
            }
            dispatcher = req.getRequestDispatcher("/editarlivro.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
