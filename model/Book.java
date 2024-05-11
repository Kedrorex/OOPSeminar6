package model;

import java.util.List;

public class Book extends PrintEdition {

    private Author author;
    private List<Author> coauthors;
    private String genre;

    public Book(String title, Author author, String genre, int year) {
        super(title, year);
        this.author = author;
        this.genre = genre;
    }

    public Book(String title, List<Author> coauthors, String genre, int year) {
        super(title, year);
        this.coauthors = coauthors;
        this.genre = genre;
    }
 
    public Author getAuthor() {
        return author;
    }

    public List<Author> getAuthorList() {
        return coauthors;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Инв.№ ").append(id).append(", '").append(title).append("', ");
        if (author != null) {
            stringBuilder.append(author);
        } else if (coauthors != null) {
            for (Author a : coauthors) {
                stringBuilder.append(a).append(", ");
            }
        }
        stringBuilder.append(",'").append(genre).append("', ").append(year).append("г.}");
        return stringBuilder.toString();
    }    
    

}