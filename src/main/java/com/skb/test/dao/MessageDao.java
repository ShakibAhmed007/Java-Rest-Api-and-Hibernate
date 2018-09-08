package com.skb.test.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.skb.test.beans.ResponseMessage;
import com.skb.test.entity.Message;
import com.skb.test.util.HibernateUtil;
import com.skb.test.util.Utilities;

public class MessageDao {

	private SessionFactory sessionFactory = null;

	public MessageDao() {
		if (sessionFactory == null) {
			sessionFactory = HibernateUtil.getSessionFactory();
		}

	}

	public ResponseMessage getMessages() {
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();

		List<Message> m = null;

		try {
			txn.begin();
			m = session.createQuery("select m from Message m").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		ResponseMessage rm = new ResponseMessage();
		rm.setResponseType("ALLMESSAGES");
		rm.setResponseCode("00");
		rm.setResponseTime(new Date());
		rm.setMessage(m);

		return rm;

	}

	public ResponseMessage getMessagesById(String messageId) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();

		Message m = null;

		try {
			txn.begin();
			m = session.get(Message.class, Integer.parseInt(messageId));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		List<Message> mList = new ArrayList();
		mList.add(m);

		ResponseMessage rm = new ResponseMessage();
		rm.setResponseType("MESSAGEBYID");
		rm.setResponseCode("00");
		rm.setResponseTime(new Date());
		rm.setMessage(mList);

		return rm;
	}

	public ResponseMessage addMessage(Message message) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			session.saveOrUpdate(message);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		ResponseMessage rm = new ResponseMessage();
		rm.setResponseType("ADDMESSAGE");
		rm.setResponseCode("00");
		rm.setResponseTime(new Date());
		rm.setMessage(null);

		return rm;
	}

	public ResponseMessage updateMessage(Message message) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			session.saveOrUpdate(message);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		ResponseMessage rm = new ResponseMessage();
		rm.setResponseType("UPDATEMESSAGE");
		rm.setResponseCode("00");
		rm.setResponseTime(new Date());
		rm.setMessage(null);

		return rm;
	}

	public ResponseMessage deleteMessage(Message message) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();

		try {
			txn.begin();
			session.delete(message);
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		ResponseMessage rm = new ResponseMessage();
		rm.setResponseType("DELETEMESSAGE");
		rm.setResponseCode("00");
		rm.setResponseTime(new Date());
		rm.setMessage(null);

		return rm;
	}

	public ResponseMessage getMessagesByDate(String date) {
		Date d = Utilities.strToDate(date);
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();
		List<Message> mList = null;
		try {
			txn.begin();
			mList = session.createQuery("select m from Message m where m.date = :date")
					.setParameter("date", d)
					.getResultList();
			txn.commit();
		} catch (Exception e) {
			if (txn != null) {
				txn.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}

		ResponseMessage rm = new ResponseMessage();
		rm.setResponseType("FILTERBYDATE");
		rm.setResponseCode("00");
		rm.setResponseTime(new Date());
		rm.setMessage(mList);

		return rm;
	}

}
