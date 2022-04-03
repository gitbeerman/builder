package com.beerman.builder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class for bb_category_level_1
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bb_category_level_1")
public class CategoryLevel_1
{	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	private long ID;

	@Column(name = "description", nullable = false)
	@Getter(AccessLevel.PUBLIC)
	@Setter(AccessLevel.PUBLIC)
	public String description;

	@Override
	public String toString()
	{	return "["+ description + "]";
	}	//toString
}	//CategoryLevel_1