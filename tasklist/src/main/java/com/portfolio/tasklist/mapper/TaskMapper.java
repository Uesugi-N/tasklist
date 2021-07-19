package com.portfolio.tasklist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portfolio.tasklist.entity.Task;

@Mapper
public interface TaskMapper {
	
	public List<Task> selectAll();
	
	public List<Task> selectIncomplete();
	
	public List<Task> selectComplete();
	
	public void add(Task task);
	
	public void update(Task task);
	
	public void delete();

}
