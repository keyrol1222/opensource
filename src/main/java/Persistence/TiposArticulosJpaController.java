package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import com.opensource.Database.TiposArticulos;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;


//Controladora de la tabla TiposArticulos
public class TiposArticulosJpaController implements Serializable{
    
    public TiposArticulosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TiposArticulosJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear el objeto en la base de datos
    public void create(TiposArticulos TA) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(TA);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Editar un objeto
    public void edit(TiposArticulos TA) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TA = em.merge(TA);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = TA.getId();
                if (findTiposArticulos(id) == null) {
                    throw new NonexistentEntityException("The TA with id " + id + " no longer exists.");
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
            TiposArticulos TA;
            try {
                TA = em.getReference(TiposArticulos.class, id);
                TA.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The TA with id " + id + " no longer exists.", enfe);
            }
            em.remove(TA);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Traer todo de la tabla
    public List<TiposArticulos> findTiposArticulosEntities() {
        return findTiposArticulosEntities(true, -1, -1);
    }

    public List<TiposArticulos> findTiposArticulosEntities(int maxResults, int firstResult) {
        return findTiposArticulosEntities(false, maxResults, firstResult);
    }

    private List<TiposArticulos> findTiposArticulosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposArticulos.class));
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

    //busca un TA a traves del id
    public TiposArticulos findTiposArticulos(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposArticulos.class, id);
        } finally {
            em.close();
        }
    }

    //trae el numero de elementos en la tabla
    public int getTiposArticulosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposArticulos> rt = cq.from(TiposArticulos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
