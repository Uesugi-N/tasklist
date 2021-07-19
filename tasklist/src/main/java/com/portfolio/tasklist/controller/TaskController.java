package com.portfolio.tasklist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.portfolio.tasklist.entity.Task;
import com.portfolio.tasklist.mapper.TaskMapper;

@Controller
public class TaskController {
	
	@Autowired
	TaskMapper taskMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		//List<Task> list = taskMapper.selectAll();
		
		List<Task> list = taskMapper.selectIncomplete();
		List<Task> donelist = taskMapper.selectComplete();
		m.addAttribute("task",list);
		m.addAttribute("donetask",donelist);
		
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(Task task) {
		taskMapper.add(task);
		
		return "redirect:/";
	}
	
	@RequestMapping("/update")
	public String update(Task task) {
		taskMapper.update(task);
		
		return "redirect:/";
	}
	
	@RequestMapping("/delete")
	public String delete() {
		taskMapper.delete();
		
		return "redirect:/";
	}
}
