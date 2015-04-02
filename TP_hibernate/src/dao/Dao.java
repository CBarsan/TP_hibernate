package dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import metier.Project;
import metier.ProjectId;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Dao {

	@SuppressWarnings("deprecation")
	public static final SessionFactory sessionFactory = new Configuration().configure()
			.buildSessionFactory();

	
	public Dao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List findAll() {
		List listeProjets = new ArrayList();
		
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			List list = s.createQuery("from Project").list();

			Iterator it = list.iterator();
			for (; it.hasNext();) { 
				Project projet = (Project) it.next();
				listeProjets.add(projet);
			  }
			
			/* JDK 5.0
			  for (Service service : (List<Service>) list) {
				listeService.add(service);
			}*/
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}

		return listeProjets;
		
		
	}

	public void delete(Project projet) {
		//Formation serviceSauve = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(projet);
			tx.commit();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		
		
	}

	public Project save(Project projet) {

		// TODO Auto-generated method stub
		Project projetSauve = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(projet);
			tx.commit();
			projetSauve = projet;
			
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}
		return projetSauve;
		
	}

	public Project findProject(String libelle) {
		// TODO Auto-generated method stub
		Project projet = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			List list = s.createQuery("from Service where libelle = ?").setString(0,
					libelle).list();
			
			tx.commit();
			
			if (list.size() > 0)
				projet = (Project) list.get(0);

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
		} finally {
			s.close();
		}

		return projet;
		
		

	}
  /*public Project serviceUpdate (Project projet)
  {
	  Project projetUpdate = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
	  try {
		  tx = s.beginTransaction();
		  System.out.println();
		  Query query = s.createQuery("update Service set interlocuteur = 'DIALOG2'" +
  				" where id = ?").setLong(0, projet.getId());
          int result = query.executeUpdate();
          tx.commit();
		
	} catch (Exception e)  {
		// TODO: handle exception
		if (tx != null)
			tx.rollback();
		// throw e;
	} finally {
		s.close();
	}
	  return service;
  }
  */
	
	public Project findProject2(ProjectId id) {
		// TODO Auto-generated method stub
		Project projet = null;
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			projet = (Project) s.get(Project.class, id);
			tx.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
		} finally {
			s.close();
		}

		return projet;
		
		

	}
}

