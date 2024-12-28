package crud.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import crud.model.Product;

@Component
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void create(Product product) {
		Session session = sessionFactory.getCurrentSession();
	    session.merge(product); 
	}
	
	
	 @Transactional
	    public List<Product> getAllProducts() {
	        Session session = sessionFactory.getCurrentSession();
	        String hql = "FROM Product"; // HQL query to fetch all products
	        return session.createQuery(hql, Product.class).getResultList();
	    }

	    @Transactional
	    public Product getOneProduct(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        return session.get(Product.class, id); // Fetch product by ID
	    }

	    @Transactional
	    public void deleteProduct(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        Product product = session.get(Product.class, id);
	        if (product != null) {
	            session.remove(product); // Delete product if it exists
	        }
	    }
}
