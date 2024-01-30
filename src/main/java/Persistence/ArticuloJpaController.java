
package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import com.opensource.Database.Articulo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;


//Controladora de la tabla articulo
public class ArticuloJpaController implements Serializable{
    
    public ArticuloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ArticuloJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear el objeto en la base de datos
    public void create(Articulo articulo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(articulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Editar un objeto
    public void edit(Articulo articulo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            articulo = em.merge(articulo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = articulo.getId();
                if (findArticulo(id) == null) {
                    throw new NonexistentEntityException("The articulo with id " + id + " no longer exists.");
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
            Articulo articulo;
            try {
                articulo = em.getReference(Articulo.class, id);
                articulo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The articulo with id " + id + " no longer exists.", enfe);
            }
            em.remove(articulo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Traer todo de la tabla
    public List<Articulo> findArticuloEntities() {
        return findArticuloEntities(true, -1, -1);
    }

    public List<Articulo> findArticuloEntities(int maxResults, int firstResult) {
        return findArticuloEntities(false, maxResults, firstResult);
    }

    private List<Articulo> findArticuloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Articulo.class));
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

    //busca un articulo a traves del id
    public Articulo findArticulo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Articulo.class, id);
        } finally {
            em.close();
        }
    }

    //trae el numero de elementos en la tabla
    public int getArticuloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Articulo> rt = cq.from(Articulo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
