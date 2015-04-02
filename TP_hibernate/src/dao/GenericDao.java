package dao;

public interface GenericDao<T> {
	
	public void create (T petitT);
	public void readAll ();
	public void readById (int id);
	public void update (T petitT);
	public void delete (T petitT);
		
}
