package us.brianolsen.spring.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import us.brianolsen.spring.web.model.Message;

@Transactional
@Repository
@Component("messagesDao")
public class MessagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	public List<Message> getMessages() {
		Criteria crit = session().createCriteria(Message.class);

		return crit.list();
	}

	public List<Message> getMessages(String username) {
		Criteria crit = session().createCriteria(Message.class);
		crit.add(Restrictions.eq("username", username));

		return crit.list();
	}

	public Message getMessage(int id) {
		Criteria crit = session().createCriteria(Message.class);
		crit.add(Restrictions.idEq(id));

		return (Message) crit.uniqueResult();
	}

	public boolean deleteMessage(int id) {
		// Even though this looks identical to the SQL statements, the advantage
		// of using HQL is that if you ever change the database schema, or
		// change the database itself. This same query will still work
		// regardless of these changes provided you update the Offer mapping.
		Query query = session().createQuery("delete from Message where id=:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	public void saveOrUpdate(Message message) {
		session().saveOrUpdate(message);
	}
}
