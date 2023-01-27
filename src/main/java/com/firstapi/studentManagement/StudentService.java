package com.firstapi.studentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStud(int id){
        return studentRepository.getStudent(id);
    }

    public String addStud(Student student){
        return studentRepository.addStudent(student);
        //this addStudent() method inside body  is from StudentRepository class
    }

    public String deleteStud(int id){
        return studentRepository.deleteStudent(id);
        //this deleteStudent() method inside body  is from StudentRepository class
    }

    public String updateStud(int id,int age){

        return studentRepository.updateStudent(id,age);
    }


}
