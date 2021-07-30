package com.org.srm.SpringApi.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.org.srm.SpringApi.Entity.Student;

import org.springframework.stereotype.Service;
@Service
public class StudentImpl implements StudentManager{
    List<Student> st=new ArrayList<>();

    @Override
    public void persitStudent(Student stud) {
      st.add(stud);
        
    }

    @Override
    public List<Student> fetchAllStudent() {
        return st;
    }
    
    @Override
    public List<String> getName() {
        
        return Arrays.asList("Akash","Goutham","Anu","Sachin");
    }
}
