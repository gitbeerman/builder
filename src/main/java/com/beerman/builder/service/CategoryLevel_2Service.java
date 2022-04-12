package com.beerman.builder.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.beerman.builder.configuration.ExampleMatchers;
import com.beerman.builder.entity.CategoryLevel_1;
import com.beerman.builder.entity.CategoryLevel_2;
import com.beerman.builder.repository.iCategoryLevel_2Repository;

import lombok.RequiredArgsConstructor;

/**
 * CategoryLevel_2Service Service
 *
 */
@Service
@RequiredArgsConstructor
public class CategoryLevel_2Service
{	@Autowired
	private iCategoryLevel_2Repository categoryLevel_2Repository;	// TODO Calling iRepository is not really a good idea, so will be replaced with it's implementation

	@Autowired
	private CategoryLevel_1Service categoryLevel_1Service;

	/**
	 * @param list of CategoryLevel_2
	 * @return list of CategoryLevel_2 saved in the DB.
	 */
	public List<CategoryLevel_2> saveCategoryLevel_2(List<CategoryLevel_2> list)
	{	return categoryLevel_2Repository.saveAll(list);
	}	//saveCategoryLevel_2



	/**
	 * @param ID
	 * @return
	 */
	public CategoryLevel_2 getCategoryLevel_2byID(long ID)
	{	return categoryLevel_2Repository.findById(ID).orElse(null);
	}	//getCategoryLevel_2byID



	/**
	 * @param categoryLevel_2
	 * @return true if the object is present, else false
	 */
	public boolean isPresent(CategoryLevel_2 categoryLevel_2)
	{	return categoryLevel_2Repository.exists(Example.of(categoryLevel_2, ExampleMatchers.getModelMatcher(ExampleMatchers.Level.LEVEL_2)));
	}	//isPresent



	public Optional<CategoryLevel_2> getCategoryLevel_2(CategoryLevel_2 categoryLevel_2)
	{	return categoryLevel_2Repository.findOne(Example.of(categoryLevel_2, ExampleMatchers.getModelMatcher(ExampleMatchers.Level.LEVEL_2)));
	}	//getCategoryLevel_2



	public void setParentCategory(CategoryLevel_2 categoryLevel_2, CategoryLevel_1 parentCategory)
	{	Optional<CategoryLevel_1> categoryLevel_1 = categoryLevel_1Service.getCategoryLevel_1(parentCategory);
		try
		{	categoryLevel_2.setParentCategoryID(categoryLevel_1.get().getID());
		}
		catch (Exception e)
		{	System.out.println("No such Element");
			e.printStackTrace();
		}
	}	//setParentCategory



	public List<CategoryLevel_2> findAllByParentID(long parentID)
	{	List<CategoryLevel_2> subCategories = categoryLevel_2Repository.findByParentCategoryID(parentID);
		subCategories = categoryLevel_2Repository.findByParentCategoryID(parentID);
		if	(null == subCategories)
		{	subCategories = Collections.emptyList();
		}
		return subCategories;
	}	//findByParentID



	public List<CategoryLevel_2> getAll()
	{	return categoryLevel_2Repository.findAll();
	}	//getAll


}	//CategoryLevel_2Service