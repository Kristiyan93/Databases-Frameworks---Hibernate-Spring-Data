package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final static String AUTHORS_FILE_PATH =
            "/Users/ElenaChuchukova/IdeaProjects/Databases Frameworks - Hibernate & Spring Data - 2019/07. Spring Data Advanced Quering/Exercise/Bookshop System Application/src/main/resources/files/authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);

        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");

            Author author = new Author();

            author.setFirstName(names[0]);
            author.setLastName(names[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    @Override
    public List<String> authorsSearch(String letters) {
        List<Author> authors = this.authorRepository.findAllByFirstNameEndingWith(letters);

        return authors
                .stream()
                .map(s -> String.format("%s %s", s.getFirstName(), s.getLastName()))
                .collect(Collectors.toList());
    }
}
