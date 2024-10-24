package br.com.consulta.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.consulta.entity.Usuario;

@WebServlet("/PesquisarUsuariosServlet")
public class PesquisarUsuariosServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            // Obtém o parâmetro de pesquisa do campo "username"
            String username = request.getParameter("username");

            if (username != null && !username.isEmpty()) {
                // Conexão com o banco via JPA
                entityManagerFactory = Persistence.createEntityManagerFactory("testPersistenceUnit");
                entityManager = entityManagerFactory.createEntityManager();

                // Consulta ao banco de dados para buscar o usuário pelo username
                List<Usuario> usuarios = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.username = :username", Usuario.class)
                        .setParameter("username", username)
                        .getResultList();

                // Passando a lista de usuários para a JSP
                request.setAttribute("usuarios", usuarios);
            }

            // Encaminhando para a página JSP de resultados (com ou sem dados)
            request.getRequestDispatcher("pesquisar.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException("Erro ao pesquisar usuários", e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
