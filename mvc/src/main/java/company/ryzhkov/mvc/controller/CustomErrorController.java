package company.ryzhkov.mvc.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CustomErrorController implements ErrorController {

    @GetMapping("/error")
    public String error404page() {
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
