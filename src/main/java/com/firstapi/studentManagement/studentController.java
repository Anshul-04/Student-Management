package com.firstapi.studentManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class studentController {

    @Autowired
    StudentService studentService;

    //get method - getting the student information
    @GetMapping("/get_student/{admNo}")
    public Student getStudent(@PathVariable("admNo") int admNo){

        return studentService.getStud(admNo);
    }

    // post method -add student
    //this is post API as it is adding the student information
    @PostMapping("/add_student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStud(student);
    }

    //delet method - deleting the student info
    @DeleteMapping("/delet_student/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        return studentService.deleteStud(id);
    }

    //put method - updating the student info
    @PutMapping("/update_student")
    public String updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
       return studentService.updateStud(id, age);
    }

}

