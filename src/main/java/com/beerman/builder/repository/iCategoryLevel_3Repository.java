package com.beerman.builder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beerman.builder.entity.CategoryLevel_3;

public interface iCategoryLevel_3Repository extends JpaRepository<CategoryLevel_3, Long>
{	public List<CategoryLevel_3> findByParentCategoryID(long ID);

	
	public List<CategoryLevel_3> findAll() ;
}	//iCategoryLevel_3Repository