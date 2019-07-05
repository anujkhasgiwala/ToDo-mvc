package edu.stanford.irt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.stanford.irt.domain.TodoItem;

@Service
@Transactional
public class TodoItemService {
	@Autowired
	private TodoItemRepository todoItemRepository;

	public List<TodoItem> list() {
		return todoItemRepository.findAll();
	}

	//to create todo item
	public TodoItem create(TodoItem todoItem) {
		return todoItemRepository.save(todoItem);
	}

	// To mark complete todo item  
	public TodoItem complete(Long id, TodoItem todoItem) {
		if(todoItemRepository.exists(id))
			todoItemRepository.save(todoItem);

		return todoItem;
	}

	//To mark complete todo item  
	public void delete(TodoItem todoItem) {
		if(todoItemRepository.exists(todoItem.getId()))
			todoItemRepository.delete(todoItem);
	}
}
