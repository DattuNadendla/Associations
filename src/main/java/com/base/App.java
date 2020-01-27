package com.base;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.model.Book;
import com.model.BookDetail;
import com.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();

		Session session = factory.openSession();
		 //saveBooks(session);
		 getBooks(session);
		HibernateUtil.closeSessionFactory();
	}

	public static void saveBooks(Session session) {
		Transaction tx = session.beginTransaction();

		BookDetail bookDetail1 = new BookDetail(221, "Sun", "ISBN123");
		Book book1 = new Book("Java", "Perry", "SW", 22, bookDetail1);

		session.save(book1);

		BookDetail bookDetail2 = new BookDetail(111, "W3Schools", "ISBN423");
		Book book2 = new Book("HTML", "John", "SW", 12, bookDetail2);

		session.save(book2);

	}

	public static void getBooks(Session session) {
		Transaction tx = session.beginTransaction();

		Query<Book> query = session.createQuery("From Book");
		List<Book> books = query.getResultList();
		books.forEach(book -> {
			System.err.println("Name: " + book.getBookName());
		});

	}
}
