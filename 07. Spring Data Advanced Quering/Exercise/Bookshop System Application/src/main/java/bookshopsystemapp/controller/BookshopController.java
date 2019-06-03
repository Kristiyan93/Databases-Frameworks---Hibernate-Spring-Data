package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class BookshopController implements CommandLineRunner {
    private final Scanner scanner;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(Scanner scanner, AuthorService authorService, CategoryService categoryService, BookService bookService) {
        this.scanner = scanner;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();

        //this.booksTitlesByAgeRestriction();
        //this.goldenBooks();
        //this.booksByPrice();
        //this.notReleasedBooks();
        //this.booksReleasedBeforeDate();
        //this.authorsSearch();
        //this.booksSearch();

    }

    private void booksSearch() {
        System.out.print("Enter, which contain a given string: ");
        String leeters = this.scanner.nextLine();

        this.bookService.booksSearch(leeters)
                .forEach(System.out::println);
    }

    private void authorsSearch() {
        System.out.print("Enter, whose first name ends with: ");
        String leeters = this.scanner.nextLine();

        this.authorService
                .authorsSearch(leeters)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() {
        System.out.print("Entar date (mm-dd-yyyy): ");
        String date = this.scanner.nextLine();

        this.bookService.booksReleasedBeforeDate(date)
        .forEach(System.out::println);
    }

    private void notReleasedBooks() {
        System.out.print("Enter years: ");

        String years = this.scanner.nextLine();

        this.bookService.notReleasedBooks(years)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        this.bookService.booksByPrice().forEach(System.out::println );
    }

    private void goldenBooks () {
        this.bookService.goldenBooks().forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() {
        System.out.print("Enter ageRestriction: ");
        String input = this.scanner.nextLine().toUpperCase();

        this.bookService.getAllBooksTitlesAfter()
                .forEach(System.out::println);
    }


}
