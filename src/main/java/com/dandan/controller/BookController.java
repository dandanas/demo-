package com.dandan.controller;

import com.dandan.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.inject.Inject;

/**
 * @date：2020/10/26
 * @author：suchao
 */
@Controller
public class BookController {

    //@Resource
    //@Autowired
    @Inject
    private BookService bookService;

    public void print(){
        System.out.println(bookService);
    }

}
