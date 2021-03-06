package todo.myTodoList.dao;

import java.util.List;

import todo.myTodoList.entity.Todo;

public interface TodoDAO {
	public void save(Todo myTodo);
	
	public List<Todo> search(Todo myTodo);
	
	public List<Todo> findAll();
	
	public String delete(Todo myTodo);
	
	public void update(Todo myTodo);
}
