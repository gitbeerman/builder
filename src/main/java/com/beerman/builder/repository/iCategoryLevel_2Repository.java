package com.beerman.builder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beerman.builder.entity.CategoryLevel_2;

public interface iCategoryLevel_2Repository extends JpaRepository<CategoryLevel_2, Long>
{	public List<CategoryLevel_2> findByParentCategoryID(long ID);
}	//iCategoryLevel_2Repository