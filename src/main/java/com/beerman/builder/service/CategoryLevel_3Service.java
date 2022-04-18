package com.beerman.builder.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.beerman.builder.configuration.ExampleMatchers;
import com.beerman.builder.entity.CategoryLevel_2;
import com.beerman.builder.entity.CategoryLevel_3;
import com.beerman.builder.repository.iCategoryLevel_3Repository;

import lombok.RequiredArgsConstructor;

/**
 * CategoryLevel_3Service Service
 *
 */
@Service
@RequiredArgsConstructor
public class CategoryLevel_3Service
{	@Autowired
	private iCategoryLevel_3Repository categoryLevel_3Repository;	// TODO Calling iRepository is not really a good idea, so will be replaced with it's implementation

	@Autowired
	private CategoryLevel_2Service categoryLevel_2Service;

	/**
	 * @param list of CategoryLevel_3
	 * @return list of CategoryLevel_3 saved in the DB.
	 */
	public List<CategoryLevel_3> saveCategoryLevel_3(List<CategoryLevel_3> list)
	{	return categoryLevel_3Repository.saveAll(list);
	}	//saveCategoryLevel_3



	/**
	 * @param ID
	 * @return
	 */
	public CategoryLevel_3 getCategoryLevel_3byID(long ID)
	{	return categoryLevel_3Repository.findById(ID).orElse(null);
	}	//getCategoryLevel_3byID



	/**
	 * @param categoryLevel_3
	 * @return true if the object is present, else false
	 */
	public boolean isPresent(CategoryLevel_3 categoryLevel_3)
	{	return categoryLevel_3Repository.exists(Example.of(categoryLevel_3, ExampleMatchers.getModelMatcher(ExampleMatchers.Level.LEVEL_3)));
	}	//isPresent



	public Optional<CategoryLevel_3> getCategoryLevel_3(CategoryLevel_3 categoryLevel_3)
	{	return categoryLevel_3Repository.findOne(Example.of(categoryLevel_3, ExampleMatchers.getModelMatcher(ExampleMatchers.Level.LEVEL_3)));
	}	//getCategoryLevel_3



	public void setParentCategory(CategoryLevel_3 categoryLevel_3, CategoryLevel_2 parentCategory)
	{	Optional<CategoryLevel_2> categoryLevel_2 = categoryLevel_2Service.getCategoryLevel_2(parentCategory);
		try
		{	categoryLevel_3.setParentCategoryID(categoryLevel_2.get().getID());
		}
		catch (Exception e)
		{	System.out.println("No such Element");
			e.printStackTrace();
		}
	}	//setParentCategory



	public List<CategoryLevel_3> findAllByParentID(long parentID)
	{	List<CategoryLevel_3> products = categoryLevel_3Repository.findByParentCategoryID(parentID);
		if	(null == products)
		{	products = Collections.emptyList();
		}
		return products;
	}
	
	
	public List<CategoryLevel_3> getAll()
	{	return categoryLevel_3Repository.findAll();
	}	///findByParentID


}	//CategoryLevel_3Service