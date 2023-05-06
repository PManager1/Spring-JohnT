package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component  //so that spring understands I need to pick this up. Its creating a Spring Bean.
public class BootstrapData implements CommandLineRunner {

//  Good practice -   Always get components from the spring context as final

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

//Create Constructoro to bring both the respositories innn.
// Thsi is the only constructor on the repositories.     when spring starts it will automatically autowire inn for theimplentnations
//    for these , that is provided by the jPa.
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override   //this method will run automatically everytiem spring boots up the app.
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book ddd = new Book();
        ddd.setTitle("Domani Driven ");
        ddd.setIsbn("3234343");

        Author ericSaved = authorRepository.save(eric);   // good prcatice not to take the saved value back.
        Book dddSaved = bookRepository.save(ddd);


        Author rod = new Author();
        eric.setFirstName("Rod");
        eric.setLastName("Johnson");

        Book noEbj = new Book();
        ddd.setTitle("J2EE Dev without EJB  ");
        ddd.setIsbn("323434323");

        Author rodSaved = authorRepository.save(rod);   // good prcatice not to take the saved value back.
        Book noEbjSaved = bookRepository.save(noEbj);

//        Now create the associating b/et two

        ericSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEbjSaved);

//        To persist these objects  V impoortant step. 
        authorRepository.save(ericSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count" + authorRepository.count());
        System.out.println("Book  count" + bookRepository.count());


    }
}











