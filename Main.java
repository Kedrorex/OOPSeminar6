import model.*;
import view.LibraryView;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляры класса Автор
        Author author1 = new Author("Т. Драйзер");
        Author author2 = new Author("Д. Оруэлл");
        Author author3 = new Author("Л.Н. Толстой");
        Author author4 = new Author("В.О. Пелевин");
        Author author5 = new Author("А.С. Пушкин");
        Author author6 = new Author("Д.С. Сугралинов");
        Author author7 = new Author("А.Н. Стругацкий");
        Author author8 = new Author("Б.Н. Стругацкий");
        Author author9 = new Author("И.А. Ильиф");
        Author author10 = new Author("Е.П. Петров");
        // Тут рассматриваем случаи если у книги несколько авторов
        LibraryView coauthors1 = new LibraryView();
        coauthors1.addAuthor(author7);
        coauthors1.addAuthor(author8);
        LibraryView coauthors2 = new LibraryView();
        coauthors2.addAuthor(author9);
        coauthors2.addAuthor(author10);
        // Создаем экземпляры класса типа PrintEditon(книги, газеты и журналы)
        PrintEdition book1 = new Book("Стоик", author1, "Современники", 1947);
        PrintEdition book2 = new Book("1984", author2, "Фантастика", 1949);
        PrintEdition book3 = new Book("Война и мир", author3, "Классика", 1865);
        PrintEdition book4 = new Book("Путешествие в Элевсин", author4, "Современники", 2023);
        PrintEdition book5 = new Book("Евгений Онегин", author5, "Классика", 1831);
        PrintEdition book6 = new Book("Дисгардиум", author6, "Фантастика", 2018);
        PrintEdition book7 = new Book("Руслан и Людмила", author5, "Классика", 1820);
        PrintEdition book8 = new Book("Пикник на обочине", coauthors1.getAuthors(), "Фантастика", 1972);
        PrintEdition book9 = new Book("Золотой телёнок", coauthors2.getAuthors(), "Комедия", 1931);
        PrintEdition book10 = new Book("Трудно быть Богом", coauthors1.getAuthors(), "Фантастика", 1963);
        // Создаём библиотеку
        LibraryView library = new LibraryView();
        library.addPublication(book1);
        library.addPublication(book2);
        library.addPublication(book3);
        library.addPublication(book4);
        library.addPublication(book5);
        library.addPublication(book6);
        library.addPublication(book7);
        library.addPublication(book8);
        library.addPublication(book9);
        library.addPublication(book10);

        // Вывод информации о всех книгах в библиотеке (первоначально)
        System.out.println(library.getLibrary());
        // Пример выдачи книги из библиотеки по названию
        library.borrowBook("Война и мир");
        library.borrowBook("Золотой телёнок");
        System.out.println(library.getLibrary());
        // Пример поиска книги по предикатам
        final String filterToFindTitle = "Дисгардиум";
        library.findBooks(book -> book.getTitle().equals(filterToFindTitle), filterToFindTitle);
        final int filterToFindYear = 2023;
        library.findBooks(book -> book.getYear() == filterToFindYear, filterToFindYear);
        final int filterToFindID = 4;
        library.findBooks(book -> book.getID() == filterToFindID, filterToFindID);
        // Пример поиска книги по автору(ам)
        final String filterToFindAuthor = "А.Н. Стругацкий"; 
        library.findBooksByAuthor(filterToFindAuthor);
        //Посмотреть список выданных книг:
        System.out.println(library.getIssuedBooks());
        //Сортируем книги по названию
        library.sortPrintEditions(PrintEditionComparator.byTitle());
        //Сортируем книги по автору
        // library.sortPrintEditionsByAuthor();
        System.out.println(library.getLibrary());
    }
}
