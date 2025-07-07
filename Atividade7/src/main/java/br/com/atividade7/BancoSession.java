package br.com.atividade7;

import jakarta.persistence.*;
import java.util.List;

public class BancoSession {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Atividade7");

    public void salvar(Banco banco) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(banco);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(Banco banco) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(banco);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(int id) {
        EntityManager em = emf.createEntityManager();
        Banco banco = em.find(Banco.class, id);
        if (banco != null) {
            em.getTransaction().begin();
            em.remove(banco);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<Banco> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Banco> lista = em.createQuery("SELECT b FROM Banco b", Banco.class).getResultList();
        em.close();
        return lista;
    }
}