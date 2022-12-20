package com.ilyafrolov.controllers;

import com.ilyafrolov.model.Book;
import com.ilyafrolov.model.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String start() {
        return "start";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public String getUser(Model model, User user) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("username", ((org.springframework.security.core.userdetails.User)context.getAuthentication().getPrincipal()).getUsername());
        model.addAttribute("age", user.getAge());
        return "user-info";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/book-start")
    public String addBook() {
        return "book-start";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/book")
    public String getBook(Model model, Book book) {
        model.addAttribute("title", book.getTitle());
        model.addAttribute("author", book.getAuthor().getName());
        model.addAttribute("genre", book.getGenre().getName());
        return "book-info";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user-or-admin")
    public String getUserAdmin(Model model, User user) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("username", ((org.springframework.security.core.userdetails.User)context.getAuthentication().getPrincipal()).getUsername());
        model.addAttribute("age", 34);
        return "user-info";
    }
}


