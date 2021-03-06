package todo.myTodoList.rest;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.myTodoList.entity.Todo;
import todo.myTodoList.service.TodoService;

@RestController
@RequestMapping("/api")
public class TodoRestController {
	
	private TodoService service;
	
	@Autowired
	public TodoRestController(TodoService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public List<Todo> getList(@RequestBody Todo myTodo){
		return service.search(myTodo);
	}
	
	@GetMapping("/searchAll")
	public List<Todo> getAll(){
		return service.findAll();
	}
	
	@PostMapping("/")
	public Todo save(@RequestBody Todo myTodo){
		myTodo.setId(0);
		long tmill=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(tmill);
		myTodo.setDate(date);
		service.save(myTodo);
		return myTodo;
	}
	
	@DeleteMapping("/")
	public void delete(@RequestBody Todo myTodo) {
		service.delete(myTodo);
	}
	
	@PutMapping("/")
	public void update(@RequestBody Todo myTodo) {
		long tmill=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(tmill);
		myTodo.setDate(date);
		service.update(myTodo);
	}
}
