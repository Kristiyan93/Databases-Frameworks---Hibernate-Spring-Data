package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.domain.entities.enums.AgeRestriction;
import bookshopsystemapp.domain.entities.enums.EditionType;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH =
    "/Users/ElenaChuchukova/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/07. Spring Data Advanced Quering/Exercise/Bookshop System Application/src/main/resources/files/books.txt";
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();

            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    @Override
    public List<String> booksTitlesByAgeRestriction(String inputAgeRestriction) {
        AgeRestriction ageRestriction = AgeRestriction.valueOf(inputAgeRestriction);

        List<Book> books = this.bookRepository.findAllByAgeRestriction(ageRestriction);
        return books
                .stream()
                .map(s -> String.format(s.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> goldenBooks() {
        List<Book> books = this.bookRepository.findAllByCopiesLessThan(5000);

        return books
                .stream()
                .map(s -> String.format(s.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksByPrice() {
        List<Book> books = this.bookRepository
                .findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

        return books
                .stream()
                .map(s -> String.format("%s - %.2f", s.getTitle(), s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> notReleasedBooks(String years) {
        LocalDate before = LocalDate.parse(years + "-01-01");
        LocalDate after = LocalDate.parse(years + "-12-31");

        List<Book> books = this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before, after);

        return books
                .stream()
                .map(s -> String.format(s.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksReleasedBeforeDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(localDate);
        return books
                .stream()
                .map(s -> String.format(s.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> booksSearch(String contain) {
        String wildCard = "%" + contain + "%";

        List<Book> books = this.bookRepository.findAllByTitleContains(wildCard);

        return books
                .stream()
                .map(s -> String.format(s.getTitle()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> bookTitlesSearch(String letters) {
        List<Book> books = this.bookRepository.findAllByTitleWhereAuthorStartWith("%" + letters);

        return books
                .stream()
                .map(s -> String.format(s.getTitle())).collect(Collectors.toList());
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

     private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }
}