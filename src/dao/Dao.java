package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import util.JpaUtil;
import model.Unit;

public class Dao {
    private static void close(EntityManager em) {
        if (em != null) em.close();
    }
    public Unit findById(Long id) {
		EntityManager em = null;
        try {
            em = JpaUtil.getFactory().createEntityManager();
            return em.find(Unit.class, id);
        } finally {
            close(em);
        }
    }

    public static List<Unit> findAllUnits() {
        EntityManager em = null;
        try {
            em = JpaUtil.getFactory().createEntityManager();

            TypedQuery<Unit> query = em.createQuery(
                    "select p from Unit p", Unit.class);

            return query.getResultList();

        } finally {
        	close(em);
        }
    }
    public List<Unit> search(String s) {
    	EntityManager em = null;
		try {
			em = JpaUtil.getFactory().createEntityManager();
			TypedQuery<Unit> query = em.createQuery("select p from Unit p"
					+ " WHERE lower(name) LIKE '%" + s.toLowerCase() + "%'", Unit.class);
			return query.getResultList();
	    } finally {
	    	close(em);
	    }
    }
    public boolean deleteAll() {
        EntityManager em = null;
        try {
        	em = JpaUtil.getFactory().createEntityManager();
        	em.getTransaction().begin();
        	Query query = em.createQuery("delete from Unit where 1=1");
            query.executeUpdate();

            em.getTransaction().commit();
        } finally {
        	close(em);
        }
        return true;
	}
	
	public boolean deleteUnit(Long id) {
        EntityManager em = null;
        try {
        	em = JpaUtil.getFactory().createEntityManager();
        	em.getTransaction().begin();
        	Unit unit = em.find(Unit.class, id);
            if (unit != null) em.remove(unit);

            em.getTransaction().commit();
        } finally {
        	close(em);
        }
        return true;
	}


    public boolean addUnit(Unit unit) {
    	EntityManager em = null;
    	try {
            em = JpaUtil.getFactory().createEntityManager();
            em.getTransaction().begin();
            if (unit.getId() == null) {
                em.persist(unit);
            } else {
                em.merge(unit);
            }

            em.getTransaction().commit();
        } finally {
        	close(em);
        }
        return true;
    }
}