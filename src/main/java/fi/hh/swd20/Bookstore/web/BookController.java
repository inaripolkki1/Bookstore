package fi.hh.swd20.Bookstore.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.domain.Student;
import fi.haagahelia.course.domain.StudentRepository;
import fi.hh.swd20.Bookstore.domain.Book;
import fi.hh.swd20.Bookstore.domain.BookstoreRepository;

@Controller
public class BookController {
	

	@Bean
	public CommandLineRunner demo(BookstoreRepository repository) {
	return (args) -> {
	 ArrayList<Book> booklist = new ArrayList<>();
	 booklist.add(new Book("A farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 49.99));
	 
	};
	}

	@RequestMapping(value="/index", method=RequestMethod.GET)
	
	public String Hello() {
		return "books";	
		
	}
	
	@Autowired
	BookstoreRepository bookRepository; 
	
    @RequestMapping(value="/booklist")
    public String booktList(Model model) {	
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
  
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addbook";
    }     
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        bookRepository.save(book);
        return "redirect:booklist";
    }    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long studentId, Model model) {
    	bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }  
}
