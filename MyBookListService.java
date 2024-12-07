package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MyBookList;
import com.example.demo.Repository.MyBookListRepository;

@Service
public class MyBookListService {

	@Autowired
	private MyBookListRepository myrepo;

	public void saveMyBooks(MyBookList mbl) {
		myrepo.save(mbl);
	}

	public List<MyBookList> getAllMyBooks() {
		return myrepo.findAll();
	}

	public void deleteById(int id) {
		myrepo.deleteById(id);
	}

}
