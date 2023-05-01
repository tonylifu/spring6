package com.lifu.test.web.bootstrap;

import com.lifu.test.web.domain.Author;
import com.lifu.test.web.domain.Book;
import com.lifu.test.web.repository.AuthorRepository;
import com.lifu.test.web.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book j2ee = new Book();
        j2ee.setTitle("Java2EE without EJB");
        j2ee.setIsbn("54321");

        Author rodSaved = authorRepository.save(rod);
        Book j2eeSaved = bookRepository.save(j2ee);

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(j2eeSaved);

        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("****In Bootstrap****");
        System.out.printf("Authors' Count: %d%n", authorRepository.count());
        System.out.printf("Books' Count: %d%n", bookRepository.count());

    }
}
