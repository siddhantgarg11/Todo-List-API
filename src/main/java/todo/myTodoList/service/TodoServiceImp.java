package todo.myTodoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import todo.myTodoList.dao.TodoDAO;
import todo.myTodoList.entity.Todo;

@Service
public class TodoServiceImp implements TodoService{
	
	private TodoDAO todo;

	@Autowired
	public TodoServiceImp(TodoDAO myTodo) {
		this.todo = myTodo;
	}

	@Override
	@Transactional
	public void save(Todo myTodo) {
		todo.save(myTodo);
	}

	@Override
	@Transactional
	public List<Todo> search(Todo myTodo) {
		return todo.search(myTodo);
	}

	@Override
	@Transactional
	public List<Todo> findAll() {
		return todo.findAll();
	}

	@Override
	@Transactional
	public String delete(Todo myTodo) {
		return todo.delete(myTodo);
	}

	@Override
	@Transactional
	public void update(Todo myTodo) {
		todo.update(myTodo);
	}
	
	
}
