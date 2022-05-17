package com.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.exception.InvalidBookException;
import com.model.Book;
import com.service.BookService;
//use appropriate annotation to configure BookController as Controller
@Controller
public class BookController {
// use appropriate annotation
@Autowired
private BookService bookService;
@RequestMapping(value = "/index", method = RequestMethod.GET)
public String showIndex() {
return "index";
}
@RequestMapping(value = "/showPage", method = RequestMethod.GET)
public String showPage(@ModelAttribute("book") Book book) {
return "showPage";
}
// invoke the service class - addBook method.
@RequestMapping(value = "/addBook", method = RequestMethod.GET)
public String addBook(@ModelAttribute("book") Book book, BindingResult result, ModelMap
model) throws InvalidBookException {
String res = "";
if (result.hasErrors()) {
res = "showpage";
} else {
boolean bool = bookService.addBook(book);
model.addAttribute("message", "Book added successfully");
res = "showpage";
}
return res;
}
// fill the code
@RequestMapping(value = "/viewList", method = RequestMethod.GET)
public String viewAllBooks(ModelMap model) {
// fill the code
List<Book> list = bookService.viewAllBooks();
model.addAttribute("bookList",list);
return "viewList";
}
// Use appropriate annotation
@ExceptionHandler(value = InvalidBookException.class)
public ModelAndView exceptionHandler(Exception e) {
ModelAndView modelAndView = new ModelAndView("exceptionPage");
modelAndView.addObject("err",e.getMessage());
// fill the code
return modelAndView;
}
@ModelAttribute("bookCategory")
public List<String> populateBookCategory() {
List<String> list = new ArrayList<>();
list.add("Science");
list.add("Humor");
list.add("Novel");
list.add("Health");
list.add("Travel");
list.add("Motivational");
list.add("Art");
list.add("Encyclopedia");
list.add("Biography");
list.add("Cooking");
return list;
}
}