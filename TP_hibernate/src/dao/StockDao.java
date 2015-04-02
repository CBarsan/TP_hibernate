package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import metier.Produit;
import metier.Stock;

public class StockDao {

	@SuppressWarnings("deprecation")
	public static final SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();

	public void findAllStock(long id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			// appel d'un select depuis la table stock
			Stock stock = (Stock) s.get(Stock.class, id);
			Set sets = stock.getProduits();

			// appel d'un select depuis la table produit
			for (Iterator iter = sets.iterator(); iter.hasNext();) {
				Produit p = (Produit) iter.next();
				System.out.print(p.getId() + " ");
				System.out.print(p.getNom() + " ");
				System.out.println();
			}
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

	public void findAllStock() {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			// appel d'un select depuis la table stock
			// Stock stock = (Stock)s.get(Stock.class, 1L);
			List<Stock> list = s.createQuery("from Stock").list();
			// Set sets = stock.getProduits();

			// appel d'un select depuis la table produit
			for (Stock stock : list) {
				Set sets = stock.getProduits();
				for (Iterator iter = sets.iterator();iter.hasNext();) 
				{
					Produit p = (Produit) iter.next();
					System.out.print(p.getId() + " ");
					System.out.print(p.getNom() + " ");
					System.out.println();
				}
			}
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

public List<Stock> findAllStock2() {
List<Stock> listeStock = new ArrayList();
		
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			listeStock = s.createQuery("from Stock").list();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}

		return listeStock;
		
	}

public List<Stock> findAllStock3() {
List<Stock> listeStock = new ArrayList();
		
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			listeStock = s.createQuery("select  distinct s from Stock s left join fetch s.produits ").list();

		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
			// throw e;
			e.printStackTrace();
		} finally {
			s.close();
		}

		return listeStock;
		
	}

	public void insertStock(Stock st) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			// appel d'un select depuis la table stock
			s.save(st);
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

	public void insertProduit(Produit p) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			// appel d'un select depuis la table stock
			s.save(p);
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

	public void insertProduitStock(long idS, long idP) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Stock st = (Stock) s.get(Stock.class, idS);
			Produit p = (Produit) s.get(Produit.class, idP);
			p.setStock(st);
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

}
