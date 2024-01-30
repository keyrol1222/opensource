
package Persistence;

import Persistence.exceptions.NonexistentEntityException;
import com.opensource.Database.Empleados;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;

//Controladora de la tabla Empleados
public class EmpleadosJpaController implements Serializable{
    
    public EmpleadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EmpleadosJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //Crear el objeto en la base de datos
    public void create(Empleados empleados) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Editar un objeto
    public void edit(Empleados empleados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empleados = em.merge(empleados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleados.getId();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
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
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    //Traer todo de la tabla
    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    //busca un empleados a traves del id
    public Empleados findEmpleados(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    //trae el numero de elementos en la tabla
    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
