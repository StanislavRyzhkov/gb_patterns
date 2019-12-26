package company.ryzhkov.mvc.controller;

import company.ryzhkov.mvc.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class IndexController {
    private final BookService bookService;

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "index";
    }
}
