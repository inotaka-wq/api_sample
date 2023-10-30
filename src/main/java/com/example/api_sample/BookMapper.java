package com.example.api_sample;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {
	@Select("SELECT id, name, page_count, author_id FROM book WHERE id=#{id}")
	Book getById(Integer id);
}
