package service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import java.util.Iterator;

import model.*;

public class LibraryService {

    private List<PrintEdition> publications = new ArrayList<>();
    private List<PrintEdition> issuedPublication = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();

    public void addPublication(PrintEdition publication) {
        publications.add(publication);
        if (publication instanceof Book) {
            Book book = (Book) publication;
            List<Author> bookAuthors = book.getAuthorList();
            if (bookAuthors != null) {
                for (Author author : bookAuthors) {
                    if (!authors.contains(author)) {
                        authors.add(author);
                    }
                }
            }
        }
    }

    private void addIssuedPublication(PrintEdition publication) {
        issuedPublication.add(publication);
    }

    public PrintEdition borrowBook(String title) {
        Iterator<PrintEdition> iterator = publications.iterator();
        while (iterator.hasNext()) {
            PrintEdition book = iterator.next();
            if (book.getTitle().equals(title)) {
                addIssuedPublication(book); // Добавляем книгу в раздел "Выданное"
                iterator.remove(); // Безопасно удаляем эту книгу из библиотеки
                return book;
            }
        }
        return null;
    }
    
    // Универсальный метод для поиска книги по заданному предикату(кроме автора(ов))
    public List<PrintEdition> findBooks(Predicate<PrintEdition> predicate, Object filter) {
        List<PrintEdition> result = new ArrayList<>();
        for (PrintEdition book : publications) {
            if (predicate.test(book)) {
                result.add(book);
            }
        }
        return result;
    }

    // Метод для поиска книги по автору(ам)
    public List<PrintEdition> findBooksByAuthor(String authorName) {
        List<PrintEdition> result = new ArrayList<>();
        for (PrintEdition book : publications) {
            if (book instanceof Book) {
                Book b = (Book) book;
                if (b.getAuthor() != null && b.getAuthor().toString().equals(authorName)) {
                    result.add(book); // Добавляем книгу, если главный автор совпадает с искомым именем
                } else if (b.getAuthorList() != null) {
                    for (Author coauthor : b.getAuthorList()) {
                        if (coauthor != null && coauthor.toString().equals(authorName)) {
                            result.add(book); // Добавляем книгу, если хотя бы один соавтор совпадает с искомым именем
                            break; // Прерываем цикл, так как книга уже добавлена
                        }
                    }
                }
            }
        }
        return result;
    }

    public List<PrintEdition> getLibrary() {
        return publications;
    }

    public List<PrintEdition> getIssuedBooks() {
        return issuedPublication;
    }

    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
