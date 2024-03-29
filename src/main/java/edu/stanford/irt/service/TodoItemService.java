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

	// To update description of todo item  
	public TodoItem update(Long id, TodoItem todoItem) {
		if(todoItemRepository.exists(id)) {
			todoItemRepository.save(todoItem);
			return todoItem;
		}

		return null;
	}

	//To mark complete todo item  
	public void delete(Long id) {
		if(todoItemRepository.exists(id))
			todoItemRepository.delete(id);
	}
}
