package company.ryzhkov.mvc.dto;

import company.ryzhkov.mvc.entity.Author;
import company.ryzhkov.mvc.entity.Book;
import lombok.Getter;

import java.util.stream.Collectors;

/*
 * При выводе списка книг на веб-странице
 * достаточно скоращенной информации о продукте
 * Реализация паттерна "Преобразователь данных"
 * */

@Getter
public class BookInfoDTO {
    private Long id;
    private final String title;
    private final int price;
    private final String description;
    private final String authorShortNames;

    private BookInfoDTO(Long id, String title, int price, String description, String authorShortNames) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.authorShortNames = authorShortNames;
    }

    private static String authorToShortName(Author author) {
        String firstLetterOfName = author.getFirstName().substring(0, 1) + ".";

        return firstLetterOfName + " " + author.getSecondName();
    }

    public static BookInfoDTO createInstance(Book book) {
        String description = book.getStyle().getName() + "; " + book.getOrigin().getName();

        String authorShortNames = book.getAuthors()
                .stream()
                .map(BookInfoDTO::authorToShortName)
                .collect(Collectors.joining("; "));

        return new BookInfoDTO(
                book.getId(),
                book.getTitle(),
                book.getPrice(),
                description,
                authorShortNames
        );
    }
}
