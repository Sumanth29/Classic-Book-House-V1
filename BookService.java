package com.service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.exception.InvalidBookException;
import com.model.Book;
//use appropriate annotation to configure ElectricityService as a Service
@Service
public class BookService {
private static ArrayList<Book> bookList=new ArrayList<Book>();
// Validate ISBN number and add book object into the book list
public boolean addBook(Book book) throws InvalidBookException {
for(Book checkBook:bookList) {
if(checkBook.getIsbn().equalsIgnoreCase(book.getIsbn())) {
throw new InvalidBookException("Book with "+book.getIsbn()+" already
exists!");
}
}
bookList.add(book);
return true;
}
public ArrayList<Book> viewAllBooks(){
//fill the code
return this.bookList;
}
public ArrayList<Book> getBookList() {
return this.bookList;
}
public void setBookList(ArrayList<Book> list) {
this.bookList = list;
}
}