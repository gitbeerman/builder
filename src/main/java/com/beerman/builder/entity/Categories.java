package com.beerman.builder.entity;

import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.beerman.builder.service.CategoryLevel_1Service;
import com.beerman.builder.service.CategoryLevel_2Service;
import com.beerman.builder.service.CategoryLevel_3Service;

public class Categories
{	//TODO This class is not complete.
	@Autowired
	private CategoryLevel_1Service categoryLevel_1Service;
	@Autowired
	private CategoryLevel_2Service categoryLevel_2Service;
	@Autowired
	private CategoryLevel_3Service categoryLevel_3Service;

	private List<CategoryLevel_1> parentCategoryList = categoryLevel_1Service.getAll();
	private Hashtable<CategoryLevel_1, List<CategoryLevel_2>> parentCategoryTable = new Hashtable<CategoryLevel_1, List<CategoryLevel_2>>();

	private List<CategoryLevel_2> subCategoryList = categoryLevel_2Service.getAll();
	private Hashtable<CategoryLevel_2, List<CategoryLevel_3>> subCategoryTable = new Hashtable<CategoryLevel_2, List<CategoryLevel_3>>();

	public void populate()
	{	parentCategoryList.clear();
		parentCategoryList = categoryLevel_1Service.getAll();
		parentCategoryTable.clear();
		subCategoryList.clear();
		subCategoryList = categoryLevel_2Service.getAll();
		subCategoryTable.clear();
		for	(CategoryLevel_1 parentCategory : parentCategoryList)
		{	parentCategoryTable.put(parentCategory, categoryLevel_2Service.findAllByParentID(parentCategory.getID()));
		}
		for	(CategoryLevel_2 subCategory : subCategoryList)
		{	subCategoryTable.put(subCategory, categoryLevel_3Service.findAllByParentID(subCategory.getID()));
		}
	}	//populate


}	//Categories