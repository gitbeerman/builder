package com.beerman.builder.utility;

import java.util.Hashtable;
import java.util.List;

import com.beerman.builder.entity.CategoryLevel_1;
import com.beerman.builder.entity.CategoryLevel_2;
import com.beerman.builder.entity.CategoryLevel_3;
import com.beerman.builder.service.CategoryLevel_1Service;
import com.beerman.builder.service.CategoryLevel_2Service;
import com.beerman.builder.service.CategoryLevel_3Service;

public class CategoryUtil
{


	public static Hashtable<CategoryLevel_1, Hashtable<CategoryLevel_2, List<CategoryLevel_3>>> mapSubCategoriesToParentCategory(CategoryLevel_1Service categoryLevel_1Service,
														CategoryLevel_2Service categoryLevel_2Service,
														CategoryLevel_3Service categoryLevel_3Service)
	{	Hashtable<CategoryLevel_1, Hashtable<CategoryLevel_2, List<CategoryLevel_3>>> parentCategoriesAndSubCategories
			= new Hashtable<CategoryLevel_1, Hashtable<CategoryLevel_2, List<CategoryLevel_3>>>();
		List<CategoryLevel_1> parentCategories = categoryLevel_1Service.getAll();
		if	(parentCategories.isEmpty())
		{	return parentCategoriesAndSubCategories;
		}
		Hashtable<CategoryLevel_2, List<CategoryLevel_3>> subCategoriesAndProducts = null;
		for	(CategoryLevel_1 parentCategory : parentCategories)
		{	subCategoriesAndProducts = mapProductsToSubCategories(categoryLevel_2Service, categoryLevel_3Service, parentCategory);
			if	(subCategoriesAndProducts.isEmpty())
			{	continue;
			}
			parentCategoriesAndSubCategories.put(parentCategory, subCategoriesAndProducts);
		}
		return parentCategoriesAndSubCategories;
	}	//mapSubCategoriesToParentCategory



	private static Hashtable<CategoryLevel_2, List<CategoryLevel_3>> mapProductsToSubCategories(CategoryLevel_2Service categoryLevel_2Service,
																								CategoryLevel_3Service categoryLevel_3Service,
																								CategoryLevel_1 parentCategory)
	{	Hashtable<CategoryLevel_2, List<CategoryLevel_3>> subCategoriesAndProducts = new Hashtable<CategoryLevel_2, List<CategoryLevel_3>>();
		subCategoriesAndProducts.clear();
		List<CategoryLevel_2> subCategories = categoryLevel_2Service.findAllByParentID(parentCategory.getID());
		if	(subCategories.isEmpty())
		{	return subCategoriesAndProducts;
		}
		List<CategoryLevel_3> products = null;
		for	(CategoryLevel_2 subCategory : subCategories)
		{	products = categoryLevel_3Service.findAllByParentID(parentCategory.getID());
			if	(!products.isEmpty())
			{	subCategoriesAndProducts.put(subCategory, products);
			}
		}
		return subCategoriesAndProducts;
	}	//mapProductsToSubCategories


}	//CategoryUtil