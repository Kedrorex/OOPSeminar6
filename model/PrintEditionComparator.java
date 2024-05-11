package model;

import java.util.Comparator;

public class PrintEditionComparator {
    // Компаратор для сортировки по ID(по умолчанию)
    public static Comparator<PrintEdition> byID() {
        return Comparator.comparing(PrintEdition::getID);
    }
    // Компаратор для сортировки по названию
    public static Comparator<PrintEdition> byTitle() {
        return Comparator.comparing(PrintEdition::getTitle);
    }
    // Компаратор для сортировки по году
    public static Comparator<PrintEdition> byYear() {
        return Comparator.comparing(PrintEdition::getYear);
    }
    // Компаратор для сортировки по авторам
    public static Comparator<PrintEdition> byAuthor() {
        return Comparator.comparing(edition -> {
            if (edition instanceof Book) {
                Book book = (Book) edition;
                Author author = book.getAuthor();
                return (author != null) ? author.toString() : "";
            } else {
                return "";
            }
        });
    }
}