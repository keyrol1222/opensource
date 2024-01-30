package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import com.opensource.Database.RentaDevolucion;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

//Controladora de la tabla Renta-Devolucion
public class RentaDevolucionJpaController implements Serializable{
    
    public RentaDevolucionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public RentaDevolucionJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear el objeto en la base de datos
    public void create(RentaDevolucion RD) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(RD);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Editar un objeto
    public void edit(RentaDevolucion RD) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RD = em.merge(RD);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = RD.getId();
                if (findRentaDevolucion(id) == null) {
                    throw new NonexistentEntityException("The RD with id " + id + " no longer exists.");
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
            RentaDevolucion RD;
            try {
                RD = em.getReference(RentaDevolucion.class, id);
                RD.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The RD with id " + id + " no longer exists.", enfe);
            }
            em.remove(RD);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Traer todo de la tabla
    public List<RentaDevolucion> findRentaDevolucionEntities() {
        return findRentaDevolucionEntities(true, -1, -1);
    }

    public List<RentaDevolucion> findRentaDevolucionEntities(int maxResults, int firstResult) {
        return findRentaDevolucionEntities(false, maxResults, firstResult);
    }

    private List<RentaDevolucion> findRentaDevolucionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RentaDevolucion.class));
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

    //busca un RD a traves del id
    public RentaDevolucion findRentaDevolucion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RentaDevolucion.class, id);
        } finally {
            em.close();
        }
    }

    //trae el numero de elementos en la tabla
    public int getRentaDevolucionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RentaDevolucion> rt = cq.from(RentaDevolucion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}
