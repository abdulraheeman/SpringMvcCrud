package com.ar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ar.dao.StudentDaoImpl;
import com.ar.model.Student;

@RestController
public class StudentController {

	@Autowired
	private StudentDaoImpl studentDao;

	@RequestMapping(value = "/studentform")
	public ModelAndView showform() {
		return new ModelAndView("studentform", "command", new Student());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView createStudent(@RequestBody Student student) {
		studentDao.create(student);
		return new ModelAndView("redirect:/viewform");
	}

	@RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ModelAndView getStudent(@PathVariable("id") int id) {
		studentDao.findOne(id);
		return new ModelAndView("redirect:/viewform");
	}

	@RequestMapping(value = "/viewStudent", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	public ModelAndView getAllStudents(@RequestBody Student student) {
		List<Student> list = studentDao.findAll(student);
		return new ModelAndView("viewform", "list", list);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
	public ModelAndView deleteStudent(@PathVariable("id") int id) {
		studentDao.delete(id);
		return new ModelAndView("redirect:/viewform");
	}

}
