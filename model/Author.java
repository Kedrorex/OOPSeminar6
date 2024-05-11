package model;

public class Author {
    private String authorName;

    public Author(String authorName){
        this.authorName = authorName;
    }

@Override
public String toString() { 
    return authorName;
}
}
