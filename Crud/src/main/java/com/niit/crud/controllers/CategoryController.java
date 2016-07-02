package com.niit.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.crud.model.Category;
import com.niit.crud.service.CategoryServiceImpl;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl categoryService;
	
	
	

	@RequestMapping(value={"/","index"})
	public String loadIndexPage()
	{
		return "index";
	}
	

	
	
	
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String listCategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("listCategory", this.categoryService.listCategory());
		return "category";
	}
	
	//For add and update person both
	@RequestMapping(value= "/category/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("category") Category p){
		
		if(p.getId() == 0){
			//new person, add it
			this.categoryService.addCategory(p);
		}else{
			//existing person, call update
			this.categoryService.updateCategory(p);
		}
		
		return "redirect:/category";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeCategory(@PathVariable("id") int id){
		
        this.categoryService.removeCategory(id);
        return "redirect:/category";
    }
 
    @RequestMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
        model.addAttribute("category", this.categoryService.getCategoryById(id));
        model.addAttribute("listCategory", this.categoryService.listCategory());
        return "category";
    }
	
}
