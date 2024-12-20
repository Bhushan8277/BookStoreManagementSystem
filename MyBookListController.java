package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.MyBookListService;

@Controller
public class MyBookListController {

	@Autowired
	private MyBookListService mbls;

	@RequestMapping("/deleteMyBook/{id}")
	public String deleteMyBook(@PathVariable("id") int id) {
		mbls.deleteById(id);
		if (mbls.getAllMyBooks().isEmpty()) {
			return "redirect:/book_available";
		}
		return "redirect:/my_books";

	}

}
