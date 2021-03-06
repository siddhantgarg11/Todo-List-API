package todo.myTodoList.service;

import java.util.List;

import todo.myTodoList.entity.Todo;

public interface TodoService {
	
	public void save(Todo myTodo);
	
	public List<Todo> search(Todo myTodo);
	
	public List<Todo> findAll();
	
	public String delete(Todo myTodo);
	
	public void update(Todo myTodo);
}
