package company.ryzhkov.mvc.service;

import company.ryzhkov.mvc.dto.BookInfoDTO;
import company.ryzhkov.mvc.entity.Book;
import company.ryzhkov.mvc.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<BookInfoDTO> findAll() {
        return ((List<Book>) bookRepository.findAll())
                .stream()
                .map(BookInfoDTO::createInstance)
                .collect(Collectors.toList());
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
}
