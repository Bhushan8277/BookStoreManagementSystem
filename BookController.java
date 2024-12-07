package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.MyBookList;
import com.example.demo.Service.BookService;
import com.example.demo.Service.MyBookListService;

@Controller
public class BookController {

	@Autowired
	private BookService bs;

	@Autowired
	private MyBookListService ms;

	@GetMapping("/")
	public String fun(Model model) {
		return "index";
	}

	@GetMapping("/register_book")
	public String register() {
		return "RegisterBook";
	}

	@GetMapping("/book_available")
	public ModelAndView available() {
		List<Book> list = bs.getAllBook();
		return new ModelAndView("BookAvailable", "xyz", list);
	}

	@GetMapping("/my_books")
	public String getBooks(Model model) {
		List<MyBookList> list = ms.getAllMyBooks();
		model.addAttribute("wxyz", list);
		return "MyBooks";
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		bs.save(b);
		return "redirect:/book_available";
	}

	@RequestMapping("/myList/{id}")
	public String getMylist(@PathVariable("id") int id) {
		Book b = bs.getBookById(id);
		MyBookList mbl = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		ms.saveMyBooks(mbl);
		return "redirect:/my_books";
	}

	@PostMapping("/") 
	public String submitUser(@ModelAttribute("user") String user, Model model) {
		if (user != null && !user.isEmpty()) {
			model.addAttribute("userName", user);
			return "redirect:/home";
		}
		return "index";
	}

	@GetMapping("/home")
	public String projectHome(Model model) {
		return "home";
	}
}
