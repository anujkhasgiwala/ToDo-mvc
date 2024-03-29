package edu.stanford.irt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
		if (todoItem.getDescription() != null && todoItem.getDescription().length() > 0)
			return todoItemService.create(todoItem);
		else
			return null; 
	}

	// this is the rest api to mark todo as complete
	@RequestMapping(value = "/api/todo-items/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TodoItem updateTodoItem(@PathVariable("id") Long id, @RequestBody TodoItem todoItem) {
		return todoItemService.update(id, todoItem);
	}


	// this is the rest api to delete todo
	@RequestMapping(value = "/api/todo-items/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void deleteTodoItem(@PathVariable("id") Long id) {
		todoItemService.delete(id);
	}
}