package Lab.a_Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private Integer years;
    private List<String> authors;

    private Book() { };

    public Book(String title, Integer years, String... authors) {
        setTitle(title);
        setYears(years);
        setAuthors(authors);
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYears(Integer years) {
        this.years = years;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getYears() {
        return this.years;
    }

    public List<String> getAuthors() {
        return this.authors;
    }
}
