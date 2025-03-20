package com.ttnAssignment.JPA3Assignment;

import com.ttnAssignment.JPA3Assignment.entity.*;
import com.ttnAssignment.JPA3Assignment.repository.AuthorRepo;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Jpa3AssignmentApplicationTests {
	@Autowired
	AuthorRepo authorRepository;

	@Test
	public void testOneToOne()
	{
		Address address = new Address(144, "Noida", "Uttar Pradesh");

		// Create a BookOneTOOne object
		BookOneTOOne book = new BookOneTOOne();
		book.setName("Java Persistence with Hibernate");

		Author author = new Author();
		author.setAuthorName("John Doe");
		author.setAddress(address);
		author.setSubjects(List.of("Java", "Hibernate", "Spring"));
		author.setBookOneTOOne(book);

		book.setAuthor(author);
		authorRepository.save(author);

		System.out.println("Data persisted successfully!");
	}

	@Test
	@Transactional
	public void testOneToManyUnidirectional()
	{
		BookOneToManyUnidirectional book1 = new BookOneToManyUnidirectional();
		book1.setName("Java Basics");

		BookOneToManyUnidirectional book2 = new BookOneToManyUnidirectional();
		book2.setName("Spring Boot Essentials");

		Author author = new Author();
		author.setAuthorName("John Doe");
		author.setSubjects(List.of("Java", "Spring"));
		author.setBookOneToManyUnidirectionals(List.of(book1, book2)); // Add books to author

		authorRepository.save(author);

		System.out.println("Unidirectional OneToMany data persisted successfully!");
	}

	@Test
	@Transactional
	public void testOneToManyBidirectional()
	{
		BookOneToMany book1 = new BookOneToMany();
		book1.setName("Spring Framework");

		BookOneToMany book2 = new BookOneToMany();
		book2.setName("Hibernate Guide");

		Author author = new Author();
		author.setAuthorName("John Doe");

		book1.setAuthor(author);
		book2.setAuthor(author);

		List<BookOneToMany> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);

		author.setBookOneToManyList(books);

		authorRepository.save(author);

		System.out.println("Bidirectional OneToMany data persisted successfully!");
	}

	@Test
	@Transactional
	public void testManyToMany()
	{
		BookManyToMany book1 = new BookManyToMany();
		book1.setName("Spring Boot Guide");

		BookManyToMany book2 = new BookManyToMany();
		book2.setName("Hibernate Advanced Topics");

		Author author1 = new Author();
		author1.setAuthorName("John Doe");

		Author author2 = new Author();
		author2.setAuthorName("Jane Smith");

		List<BookManyToMany> books = new ArrayList<>();
		books.add(book1);
		books.add(book2);

		author1.setBookManyToManyList(books);
		author2.setBookManyToManyList(books);

		List<Author> authors = new ArrayList<>();
		authors.add(author1);
		authors.add(author2);

		book1.setAuthors(authors);
		book2.setAuthors(authors);

		authorRepository.save(author1);
		authorRepository.save(author2);

		System.out.println("Many-to-Many data persisted successfully!");
	}
}
