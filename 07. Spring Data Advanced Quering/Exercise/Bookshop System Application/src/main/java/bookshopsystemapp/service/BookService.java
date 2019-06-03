package bookshopsystemapp.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> booksTitlesByAgeRestriction(String inputAgeRestriction);

    List<String> goldenBooks();

    List<String> booksByPrice();

    List<String> notReleasedBooks(String years);

    List<String> booksReleasedBeforeDate(String date);

    List<String> booksSearch(String contain);

    List<String> bookTitlesSearch(String letters);
}
