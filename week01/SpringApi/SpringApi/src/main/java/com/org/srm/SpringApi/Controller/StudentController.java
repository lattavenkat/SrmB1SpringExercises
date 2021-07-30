package com.org.srm.SpringApi.Controller;

import java.util.List;

import com.org.srm.SpringApi.Entity.Student;
import com.org.srm.SpringApi.Service.StudentManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController extends BaseController{
    @Autowired
  private StudentManager sservice;
 
  @GetMapping(value = "names",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<String>> getName()
  {
      return new ResponseEntity<List<String>>(sservice.getName(),HttpStatus.OK);
  }

  @GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Student>> fetchById(@PathVariable int id) throws Exception {
      System.out.println(id);
      return new ResponseEntity<List<Student>>(sservice.fetchAllStudent(), HttpStatus.OK);
  }

  @PostMapping(value = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Student>> addStudent(@RequestBody(required = false) Student stu){
      System.out.println(stu);
      sservice.persitStudent(stu);
      return new ResponseEntity<List<Student>>(sservice.fetchAllStudent(),HttpStatus.OK);
  }
  @PutMapping(value = "/students",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Student>> updateStudent(@RequestBody Student stud){
      //logger.debug(stud.toString());
      System.out.println(stud);
      sservice.persitStudent(stud);
      return new ResponseEntity<List<Student>>(sservice.fetchAllStudent(),HttpStatus.OK);
  }
}
