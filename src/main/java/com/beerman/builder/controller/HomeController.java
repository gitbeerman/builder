package com.beerman.builder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beerman.builder.entity.CategoryLevel_1;
import com.beerman.builder.entity.CategoryLevel_2;
import com.beerman.builder.entity.CategoryLevel_3;
import com.beerman.builder.service.CategoryLevel_1Service;
import com.beerman.builder.service.CategoryLevel_2Service;
import com.beerman.builder.service.CategoryLevel_3Service;



/**
 * Home Controller
 */
@RestController
public class HomeController
{	@Autowired
	private CategoryLevel_1Service categoryLevel_1Service;
	@Autowired
	private CategoryLevel_2Service categoryLevel_2Service;
	@Autowired
	private CategoryLevel_3Service categoryLevel_3Service;



	/**
	 * @param CategoryLevel_1 that is to be saved.
	 */
	@RequestMapping(value="/parentCategory", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postCategoryLevel_1(@RequestBody List<CategoryLevel_1> categoryLevel_1)
	{	categoryLevel_1Service.saveCategoryLevel_1(categoryLevel_1);
	}	//postCategoryLevel_1



	/**
	 * @param CategoryLevel_2 that is to be saved.
	 */
	@RequestMapping(value="/subCategory/{parentCategory}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postCategoryLevel_2(@RequestBody List<CategoryLevel_2> categoryLevel_2, @PathVariable(required = true) String parentCategory)
	{	CategoryLevel_1 parentCategoryLevel_1 = new CategoryLevel_1();
		parentCategoryLevel_1.setDescription(parentCategory);
		for	(CategoryLevel_2 category : categoryLevel_2)
		{	categoryLevel_2Service.setParentCategory(category, parentCategoryLevel_1);
		}
		categoryLevel_2Service.saveCategoryLevel_2(categoryLevel_2);
	}	//postCategoryLevel_2



	/**
	 * @param CategoryLevel_3 that is to be saved.
	 */
	@RequestMapping(value="/products/{subCategory}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postCategoryLevel_3(@RequestBody List<CategoryLevel_3> categoryLevel_3, @PathVariable(required = true) String subCategory)
	{	CategoryLevel_2 parentCategoryLevel_2 = new CategoryLevel_2();
		parentCategoryLevel_2.setDescription(subCategory);
		for	(CategoryLevel_3 category : categoryLevel_3)
		{	categoryLevel_3Service.setParentCategory(category, parentCategoryLevel_2);
		}
		categoryLevel_3Service.saveCategoryLevel_3(categoryLevel_3);
	}	//postCategoryLevel_3



	@RequestMapping(value="/getParentCategories", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryLevel_1> getParentCategory()
	{	return categoryLevel_1Service.getAll();
	}	//getParentCategory



	@RequestMapping(value="/getSubCategories/{parentCategoryDescription}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryLevel_2> getSubCategory(@PathVariable(required = true) String parentCategoryDescription)
	{	CategoryLevel_1 parentCategory = new CategoryLevel_1();
		parentCategory.setDescription(parentCategoryDescription);
		Optional<CategoryLevel_1> parentObject = categoryLevel_1Service.getCategoryLevel_1(parentCategory);
		if	(parentObject.isEmpty())
		{	return null;
		}
		return categoryLevel_2Service.findAllByParentID(parentObject.get().getID());
	}	//getParentCategory



	@RequestMapping(value="/getProducts/{subCategoryDescription}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryLevel_3> getProducts(@PathVariable(required = true) String subCategoryDescription)
	{	CategoryLevel_2 subCategory = new CategoryLevel_2();
		subCategory.setDescription(subCategoryDescription);
		Optional<CategoryLevel_2> subObject = categoryLevel_2Service.getCategoryLevel_2(subCategory);
		if	(subObject.isEmpty())
		{	return null;
		}
		return categoryLevel_3Service.findAllByParentID(subObject.get().getID());
	}	//getParentCategory
}	//HomeController