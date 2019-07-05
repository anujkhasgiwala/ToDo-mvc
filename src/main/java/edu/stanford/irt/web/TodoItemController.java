package edu.stanford.irt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.stanford.irt.domain.TodoItem;
import edu.stanford.irt.service.TodoItemService;

@RestController
public class TodoItemController {
	@Autowired
	private TodoItemService todoItemService;

	// this is the rest api to get todo
	@RequestMapping(value = "/api/todo-items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@Transactional(readOnly = true)
	public List<TodoItem> getTodoItems() {
		return todoItemService.list();
	}

	// this is the rest api to create todo
	@RequestMapping(value = "/api/todo-items", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TodoItem createTodoItem(TodoItem todoItem) {
		return todoItemService.create(todoItem);
	}

	// this is the rest api to mark todo as complete
	@RequestMapping(value = "/api/todo-items/update/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TodoItem completeTodoItem(Long id, TodoItem todoItem) {
		return todoItemService.complete(id, todoItem);
	}
	
	
	// this is the rest api to mark todo as complete
	@RequestMapping(value = "/api/todo-items/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TodoItem deleteTodoItem(Long id, TodoItem todoItem) {
		return todoItemService.complete(id, todoItem);
	}
}