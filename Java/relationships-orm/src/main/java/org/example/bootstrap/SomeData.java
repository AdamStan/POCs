package org.example.bootstrap;

import org.example.model.manytomany.Author;
import org.example.model.manytomany.Book;
import org.example.model.manytoone.Answer;
import org.example.model.manytoone.Question;
import org.example.model.onetoone.User;
import org.example.model.onetoone.UserDetails;
import org.example.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class SomeData implements CommandLineRunner {
    private static Logger log = Logger.getLogger("SomeData");
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;

    public SomeData(AuthorRepository authorRepository, BookRepository bookRepository, QuestionRepository questionRepository,
                    AnswerRepository answerRepository, UserRepository userRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        addSomeDataManyToMany();
        addSomeDataManyToOne();
        addSomeDataOneToOne();
    }

    private void addSomeDataManyToMany() {
        Author auth1 = new Author();
        auth1.setName("Adam");
        auth1.setSurname("Jestem");

        Author auth2 = new Author();
        auth2.setName("Monika");
        auth2.setSurname("Jestem");

        Book book = new Book();
        book.setTitle("Some title");

        auth1.getBooks().add(book);
        auth2.getBooks().add(book);
        book = bookRepository.save(book);
        // Author is the king of the relationship - it has an annotation - JoinTable!
        authorRepository.save(auth1);
        authorRepository.save(auth2);
        log.info("Saved a book of two authors: " + book);
        log.info("Look! An empty list of authors here!");
    }

    private void addSomeDataManyToOne() {
        Answer a1 = new Answer();
        a1.setAnswer("AAA");
        a1 = answerRepository.save(a1);
        log.info("Answer was saved: " + a1);
        Question q1 = new Question();
        q1.setQuestion("Q??");
        q1.setAnswer(a1);
        q1 = questionRepository.save(q1);
        log.info("Question was saved: " + q1);
    }

    private void addSomeDataOneToOne() {
        UserDetails d = new UserDetails();
        d.setEmail("mail@to.c");
        d.setPhoneNumber("892341242");
// You cannot save a detail, when you save it with null you cannot use it for a user
//        d = userDetailsRepository.save(d);
//        log.info("Details were saved: " + d);
        User u = new User();
        u.setUsername("super_name");
        u.setDetails(d);
        u = userRepository.save(u);
        log.info("User was saved: " + u);
    }
}
