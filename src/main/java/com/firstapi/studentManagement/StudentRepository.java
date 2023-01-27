package com.firstapi.studentManagement;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer, Student> db = new HashMap<>();

    public Student getStudent(int id) {
        return db.get(id);
    }

    public String addStudent(Student student) {
        int admNo = student.getAdmNo();
        db.put(admNo, student);
        return "Student added successfully.";
    }

    public String deleteStudent(int id) {
        if (!db.containsKey(id)) {
            return "Invalid ID";
        }
        db.remove(id);
        return "Student Deleted successfully.";
    }

    public String updateStudent(int id,int age) {
        if(!db.containsKey(id)){
            return null;
        }
        Student student = db.get(id);  //getting the student
        student.setAge(age); // setting the new age for student age
        db.put(id,student); //putting back the updated info into the hashmap

        //or
        //db.get(id).setAge(age);

        return "Student information Updated successfully.";
    }
}
