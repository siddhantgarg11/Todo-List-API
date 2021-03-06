package todo.myTodoList.dao;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import todo.myTodoList.entity.Todo;

@Repository
public class TodoDaoImp implements TodoDAO {
	
	private EntityManager theEntityManager;
	
	@Autowired
	public TodoDaoImp(EntityManager theEntityManager) {
		this.theEntityManager = theEntityManager;
	}

	@Override
	@Transactional
	public void save(Todo myTodo) {
		Session currentSession=theEntityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(myTodo);
	}

	@Override
	@Transactional
	public List<Todo> search(Todo myTodo) {
		Session currentSession=theEntityManager.unwrap(Session.class);
		Query<Todo> theQuery;
		String title=myTodo.getTitle();
		Date date =myTodo.getDate();
		Integer priority=myTodo.getPriority();
		String state=myTodo.getState();
		String order="Order by priority ASC";
		if(title!=null) {
			theQuery=currentSession.createQuery("from Todo where title=:myTitle "+order,Todo.class);
			theQuery.setParameter("myTitle", title);
			List<Todo>list=theQuery.getResultList();
			return list;
		}
		else if(date!=null) {
			theQuery=currentSession.createQuery("from Todo where date=:myDate"+order,Todo.class);
			theQuery.setParameter("myDate", date);
			List<Todo>list=theQuery.getResultList();
			return list;
		}
		else if(state!=null){
			theQuery=currentSession.createQuery("from Todo where priority=:myPriority"+order,Todo.class);
			theQuery.setParameter("myPriority", priority);
			List<Todo>list=theQuery.getResultList();
			return list;
		}
		return null;
	}

	@Override
	@Transactional
	public List<Todo> findAll() {
		Session currentSession=theEntityManager.unwrap(Session.class);
		Query<Todo> theQuery=currentSession.createQuery("from Todo Order by priority ASC",Todo.class);
		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public String delete(Todo myTodo) {
		Session currentSession=theEntityManager.unwrap(Session.class);
		Query<Todo> theQuery;
		String title=myTodo.getTitle();
		Date date =myTodo.getDate();
		Integer priority=myTodo.getPriority();
		String state=myTodo.getState();
		if(title!=null) {
			theQuery=currentSession.createQuery("delete from Todo where title=:myTitle");
			theQuery.setParameter("myTitle", title);
			theQuery.executeUpdate();
		}
		else if(date!=null) {
			theQuery=currentSession.createQuery("delete from Todo where date=:myDate");
			theQuery.setParameter("myDate", date);
			theQuery.executeUpdate();
		}
		else if(state!=null){
			theQuery=currentSession.createQuery("delete from Todo where priority=:myPriority");
			theQuery.setParameter("myPriority", priority);
			theQuery.executeUpdate();
		}
		return "Delete Successful...!!";
	}

	@Override
	@Transactional
	public void update(Todo myTodo) {
		Session currentSession=theEntityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(myTodo);
	}
	
	
	
}
