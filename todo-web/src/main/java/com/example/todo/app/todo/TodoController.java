package com.example.todo.app.todo;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.model.Todo;
import com.example.todo.domain.service.todo.TodoService;

@Controller // (1)
@RequestMapping("todo") // (2)
public class TodoController {
	@Inject // (1)
	TodoService todoService;

	@ModelAttribute // (2)
	public TodoForm setUpForm() {
		TodoForm form = new TodoForm();
		return form;
	}

	@GetMapping("list") // (3)
	public String list(Model model) {
		Collection<Todo> todos = todoService.findAll();
		model.addAttribute("todos", todos); // (4)
		return "todo/list"; // (5)
	}
}
