package com.niit.crud.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.crud.model.Category;


@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sf;
	
	public CategoryDAOImpl() {
		
	}
	private static final Logger logger = LoggerFactory.getLogger(CategoryDAOImpl.class);

	//private SessionFactory sessionFactory;
	
	/*public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}*/
	//@Override
	public void addCategory(Category p) {
		Session session = this.sf.getCurrentSession();
		session.persist(p);
		logger.info("Person saved successfully, Person Details="+p);
	}

	//@Override
	public void updateCategory(Category p) {
		Session session = this.sf.getCurrentSession();
		session.update(p);
		logger.info("Person updated successfully, Person Details="+p);
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<Category> listCategory() {
		Session session = sf.getCurrentSession();
		
		List<Category> personsList = session.createQuery("from Category").list();
		/*for(Category p : personsList){
			logger.info("Category List::"+p);
		}*/
		return personsList;
	}

	//@Override
	public Category getCategoryById(int id) {
		Session session = this.sf.getCurrentSession();		
		Category p = (Category) session.load(Category.class, new Integer(id));
		logger.info("Category loaded successfully, Category details="+p);
		return p;
	}
	//@Override
	public void removeCategory(int id) {
		Session session = this.sf.getCurrentSession();
		Category p = (Category) session.load(Category.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Category deleted successfully, category details="+p);
	}

}
