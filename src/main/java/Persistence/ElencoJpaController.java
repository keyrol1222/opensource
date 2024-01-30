package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import com.opensource.Database.Elenco;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

//Controladora de la tabla Elenco
public class ElencoJpaController implements Serializable{
    
    public ElencoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ElencoJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear el objeto en la base de datos
    public void create(Elenco elenco) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(elenco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Editar un objeto
    public void edit(Elenco elenco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            elenco = em.merge(elenco);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = elenco.getId();
                if (findElenco(id) == null) {
                    throw new NonexistentEntityException("The elenco with id " + id + " no longer exists.");
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
            Elenco elenco;
            try {
                elenco = em.getReference(Elenco.class, id);
                elenco.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The elenco with id " + id + " no longer exists.", enfe);
            }
            em.remove(elenco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Traer todo de la tabla
    public List<Elenco> findElencoEntities() {
        return findElencoEntities(true, -1, -1);
    }

    public List<Elenco> findElencoEntities(int maxResults, int firstResult) {
        return findElencoEntities(false, maxResults, firstResult);
    }

    private List<Elenco> findElencoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Elenco.class));
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

    //busca un elenco a traves del id
    public Elenco findElenco(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Elenco.class, id);
        } finally {
            em.close();
        }
    }

    //trae el numero de elementos en la tabla
    public int getElencoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Elenco> rt = cq.from(Elenco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
