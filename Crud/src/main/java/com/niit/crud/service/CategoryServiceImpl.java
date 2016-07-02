package com.niit.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.niit.crud.dao.CategoryDAO;
import com.niit.crud.dao.CategoryDAOImpl;
import com.niit.crud.model.Category;

@Transactional
@Service
public class CategoryServiceImpl {
	
	public CategoryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private CategoryDAOImpl categoryDAO;

	

	//@Override
	@Transactional
	public void addCategory(Category p) {
		this.categoryDAO.addCategory(p);
	}

	//@Override
	@Transactional
	public void updateCategory(Category p) {
		this.categoryDAO.updateCategory(p);
	}

	//@Override
	@Transactional
	public List<Category> listCategory() {
		return this.categoryDAO.listCategory();
	}

	//@Override
	@Transactional
	public Category getCategoryById(int id) {
		return this.categoryDAO.getCategoryById(id);
	}

	//@Override
	@Transactional
	public void removeCategory(int id) {
		this.categoryDAO.removeCategory(id);
	}

}
