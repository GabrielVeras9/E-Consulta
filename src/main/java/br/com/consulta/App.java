package br.com.consulta;

import br.com.consulta.entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Tentando conectar ao banco de dados Oracle via JPA..." );

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            // Inicializando EntityManagerFactory com o nome do persistence-unit definido no persistence.xml
            entityManagerFactory = Persistence.createEntityManagerFactory("testPersistenceUnit");
            entityManager = entityManagerFactory.createEntityManager();

            if (entityManagerFactory != null) {
                System.out.println("Conexão com o banco de dados Oracle foi concluída com sucesso via JPA!");

                // Iniciando transação
                entityManager.getTransaction().begin();

                // Realizando o select * from USUARIOS
                List<Usuario> usuarios = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();

                // Exibindo o resultado da consulta
                for (Usuario usuario : usuarios) {
                    System.out.println("ID: " + usuario.getIdUsuario() + ", Username: " + usuario.getUsername() + ", Nome: " + usuario.getNomeUsuario());
                }

                // Finalizando transação
                entityManager.getTransaction().commit();
            } else {
                System.out.println("Falha ao estabelecer conexão com o banco de dados Oracle.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco de dados via JPA: " + e.getMessage());
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback(); // Desfaz a transação em caso de erro
            }
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
