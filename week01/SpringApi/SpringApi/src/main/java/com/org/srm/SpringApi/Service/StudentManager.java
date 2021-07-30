package com.org.srm.SpringApi.Service;

import java.util.List;

import com.org.srm.SpringApi.Entity.Student;

import org.springframework.stereotype.Service;

@Service
public interface StudentManager {
    public List<String> getName();

    public void persitStudent(Student stud);

    public List<Student> fetchAllStudent();
}
