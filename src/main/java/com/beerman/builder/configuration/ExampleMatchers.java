package com.beerman.builder.configuration;

import org.springframework.data.domain.ExampleMatcher;

public class ExampleMatchers
{	public static enum Level
	{	LEVEL_1, LEVEL_2, LEVEL_3
	}

	public static ExampleMatcher getModelMatcher(Level level)
	{	ExampleMatcher matcher;
		switch (level)
		{	case LEVEL_1:
				matcher = ExampleMatcher.matching()
										.withIgnorePaths("ID")
										.withIgnoreCase();
				break;
			case LEVEL_2:
				matcher = ExampleMatcher.matching()
										.withIgnorePaths("ID")
										.withIgnorePaths("parentCategoryID")
										.withIgnoreCase();
				break;
			case LEVEL_3:
				matcher = ExampleMatcher.matching()
										.withIgnorePaths("ID")
										.withIgnorePaths("parentCategoryID")
										.withIgnoreCase();
				break;
			default:
				matcher = ExampleMatcher.matching()
										.withIgnorePaths("ID").withIgnoreCase();
				break;
		}
		return matcher;
	}	//getModelMatcher


}	//ExampleMatchers