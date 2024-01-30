package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import com.opensource.Database.Idiomas;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

//Controladora de la tabla Idiomas
public class IdiomasJpaController implements Serializable{
    
    public IdiomasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public IdiomasJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear el objeto en la base de datos
    public void create(Idiomas idiomas) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(idiomas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Editar un objeto
    public void edit(Idiomas idiomas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            idiomas = em.merge(idiomas);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = idiomas.getId();
                if (findIdiomas(id) == null) {
                    throw new NonexistentEntityException("The idiomas with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Eliminar un objeto
    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Idiomas idiomas;
            try {
                idiomas = em.getReference(Idiomas.class, id);
                idiomas.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The idiomas with id " + id + " no longer exists.", enfe);
            }
            em.remove(idiomas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Traer todo de la tabla
    public List<Idiomas> findIdiomasEntities() {
        return findIdiomasEntities(true, -1, -1);
    }

    public List<Idiomas> findIdiomasEntities(int maxResults, int firstResult) {
        return findIdiomasEntities(false, maxResults, firstResult);
    }

    private List<Idiomas> findIdiomasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Idiomas.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    //busca un idiomas a traves del id
    public Idiomas findIdiomas(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Idiomas.class, id);
        } finally {
            em.close();
        }
    }

    //trae el numero de elementos en la tabla
    public int getIdiomasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Idiomas> rt = cq.from(Idiomas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
