package com.firstapi.studentManagement;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class studentController {

    @Autowired
    StudentService studentService;

    //get method - getting the student information
    @GetMapping("/get_student/{admNo}")
    public ResponseEntity getStudent(@PathVariable("admNo") int admNo){
        Student response = studentService.getStud(admNo);
        return new ResponseEntity<>(response, HttpStatus.FOUND);

    }

    // post method -add student
    //this is post API as it is adding the student information
    @PostMapping("/add_student")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStud(student);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    //delet method - deleting the student info
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") int id){
        String response = studentService.deleteStud(id);
        if(response.equals("Invalid ID")) {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    //put method - updating the student info
    @PutMapping("/update_student")
    public ResponseEntity updateStudent(@RequestParam("id") int id,@RequestParam("age") int age){
       String response = studentService.updateStud(id,age);
      if(response==null){
          return new  ResponseEntity<>("Invalid ID",HttpStatus.BAD_REQUEST);
      }
        return  new ResponseEntity<>("Successfully Updated",HttpStatus.ACCEPTED);
    }

}

