package com.ilyafrolov.controllers;

import com.ilyafrolov.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @RequestMapping(method= RequestMethod.GET, value="/")
    public String start() {
        return "start";
    }

    @RequestMapping(method=RequestMethod.POST, value="/book")
    public String getUser(Model model, Book book) {
        model.addAttribute("title", book.getTitle());
        model.addAttribute("author", book.getAuthor().getName());
        model.addAttribute("genre", book.getGenre().getName());
        return "book-info";
    }
}
