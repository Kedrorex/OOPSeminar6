package controll;

import java.util.List;
import java.util.function.Predicate;

import model.*;
import service.LibraryService;

public class LibraryController {

    LibraryService service = new LibraryService();

    public void addPublication(PrintEdition publication) {
        service.addPublication(publication);
    }

    public PrintEdition borrowBook(String title) {
        return service.borrowBook(title);
    }

    public List<PrintEdition> findBooks(Predicate<PrintEdition> predicate, Object filter) {
        return service.findBooks(predicate, filter);
    }

    public List<PrintEdition> findBooksByAuthor(String authorName) {
        return service.findBooksByAuthor(authorName);
    }

    public List<PrintEdition> getLibrary() {
        return service.getLibrary();
    }

    public List<PrintEdition> getIssuedBooks() {
        return service.getIssuedBooks();
    }

    public List<Author> getAuthors() {
        return service.getAuthors();
    }

}
