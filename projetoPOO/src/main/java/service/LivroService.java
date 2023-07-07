
package service;

import dao.LivroDAO;
import model.Livro;

import java.util.List;

public class LivroService {

    /*---------> Cadastrar Livro<---------*/
    public boolean cadastrarLivro(Livro livro) {
        LivroDAO livroDAO = new LivroDAO();
        // Adicionar o livro no banco de dados
        livroDAO.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso: " + livro.getNome());
        return true;
    }
    /*---------> Deletar Livro<---------*/
    public boolean deletarLivro(Livro livro) {
        LivroDAO livroDAO = new LivroDAO();
        // Deleta o livro do banco de dados
        livroDAO.deletarLivro(livro);
        System.out.println("Livro delatado com sucesso: " + livro.getId());
        return true;
    }

    /*---------> Editar Livro<---------*/
    public boolean editarLivro(Livro livro) {
        LivroDAO livroDAO = new LivroDAO();
        // Edita o livro do banco de dados
        livroDAO.editarLivro(livro);
        System.out.println("Livro editado com sucesso: " + livro.getNome());
        return true;
    }

}
