package fi.hh.swd20.Bookstore.web;

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

@Controller
public class BookController {
	
}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
	 // Your code...add some demo data to db
	};
	

	@RequestMapping(value="/index", method=RequestMethod.GET)
	
	public String Hello() {
		return "books";	
		
	}
	
	@Autowired
	private BookRepository bookRepository; 
	
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
