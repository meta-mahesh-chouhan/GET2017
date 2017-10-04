package com.metacube.shoppingcart.dao.product;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.model.Product;


@Repository("hibernateProductDao")
public class HibernateProductDao extends GenericHibernateDao<Product, Integer> implements ProductDao {
	
	public HibernateProductDao() {
		super(Product.class);
	}



	@Override
	public Product findOne(Integer primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(Integer primaryKey) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Product entity) {
		 Session session = sessionFactory.getCurrentSession();
	      Product book2 = session.byId(getModelClass()).load("id");
	      book2.setTitle(book.getTitle());
	      book2.setAuthor(book.getAuthor());
	      session.flush();
		
	}


}
