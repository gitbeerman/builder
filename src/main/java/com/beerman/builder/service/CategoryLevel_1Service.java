package com.beerman.builder.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.beerman.builder.configuration.ExampleMatchers;
import com.beerman.builder.entity.CategoryLevel_1;
import com.beerman.builder.repository.iCategoryLevel_1Repository;

import lombok.RequiredArgsConstructor;

/**
 * CategoryLevel_1Service Service
 *
 */
@Service
@RequiredArgsConstructor
public class CategoryLevel_1Service
{	@Autowired
	private iCategoryLevel_1Repository categoryLevel_1Repository;	// TODO Calling iRepository is not really a good idea, so will be replaced with it's implementation

	/**
	 * @param list of CategoryLevel_1
	 * @return list of CategoryLevel_1 saved in the DB.
	 */
	public List<CategoryLevel_1> saveCategoryLevel_1(List<CategoryLevel_1> list)
	{	return categoryLevel_1Repository.saveAll(list);
	}	//saveCategoryLevel_1



	/**
	 * @param ID
	 * @return
	 */
	public CategoryLevel_1 getCategoryLevel_1byID(long ID)
	{	return categoryLevel_1Repository.findById(ID).orElse(null);
	}	//getCategoryLevel_1byID



	/**
	 * @param categoryLevel_1
	 * @return true if the object is present, else false
	 */
	public boolean isPresent(CategoryLevel_1 categoryLevel_1)
	{	return categoryLevel_1Repository.exists(Example.of(categoryLevel_1, ExampleMatchers.getModelMatcher(ExampleMatchers.Level.LEVEL_1)));
	}	//isPresent



	public Optional<CategoryLevel_1> getCategoryLevel_1(CategoryLevel_1 categoryLevel_1)
	{	return categoryLevel_1Repository.findOne(Example.of(categoryLevel_1, ExampleMatchers.getModelMatcher(ExampleMatchers.Level.LEVEL_1)));
	}	//getCategoryLevel_1



	public List<CategoryLevel_1> getAll()
	{	List<CategoryLevel_1> parentCategories = categoryLevel_1Repository.findAll();
		if	(null == parentCategories)
		{	parentCategories = Collections.emptyList();
		}
		return parentCategories;
	}	//getAll


}	//CategoryLevel_1Service