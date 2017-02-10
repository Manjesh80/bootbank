package com.shivbank;

import com.shivbank.entity.Author;
import com.shivbank.entity.Book;
import com.shivbank.entity.Publisher;
import com.shivbank.entity.Reviewer;
import com.shivbank.repository.AuthorRepository;
import com.shivbank.repository.BookRepository;
import com.shivbank.repository.PublisherRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;

/**
 * Created by aadhya on 2/8/2017.
 */

@Order(1000)
public class StartupRunner implements CommandLineRunner {
    protected final Log LOG = LogFactory.getLog(getClass());

    @Autowired
    private DataSource ds;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Total number of books ==> " + bookRepository.count());

       /* Author author = new Author("Alex", "Antonov");
        author = authorRepository.save(author);
        Reviewer reviewer = new Reviewer("Ganesh", "Kumar");
        Publisher publisher = new Publisher("Packt");
        publisher = publisherRepository.save(publisher);
        Book book = new Book("978-1-78528-415-1", "Spring Boot Recipes", author, publisher);
        book = bookRepository.save(book);*/
        /*book.setReviewers(Arrays.asList(reviewer));
        bookRepository.save(book);*/
    }

    @Scheduled(initialDelay = 1000, fixedRate = 300000)
    public void run() {
        LOG.info("Number of books: " + bookRepository.count());

    }
}
