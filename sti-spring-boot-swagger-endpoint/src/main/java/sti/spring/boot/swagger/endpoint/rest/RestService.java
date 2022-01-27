package sti.spring.boot.swagger.endpoint.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sti.spring.boot.swagger.endpoint.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/service")
public class RestService {

    private static List<Student> students;

    public RestService(){
        students = Arrays.asList(
                new Student("Nasir", "Tedros"),
                new Student ("Oskar", "Wadin"),
                new Student("Luliya", "Masfun"));
    }

    @GetMapping(("/getstudentnames"))
    @ApiOperation(value = "Gets the names of all students")
    public List<String> getStudentNames(){
        //TODO: refactor Java 7 for-loop to Java 8 stream
        List<String> studentNames = new ArrayList<>();
        for(Student student : students){
            studentNames.add(student.toString());
        }
        return studentNames;
    }

    @GetMapping("/getbygivenname")
    @ApiOperation(value = "Takes a given name as input")
    public Student getUserByGivenName(@RequestParam String givenName){
        Student student = null;
        for(Student s : students){
            if(s.getGivenName().equalsIgnoreCase(givenName)){
                student = s;
            }
        }
        return student;
    }

    @PostMapping("/addnewstudent")
    @ApiOperation(value = "Adds a new student")
    public void addStudent(@RequestBody Student newStudent){
        students.add(new Student(newStudent.getGivenName(), newStudent.getSurName()));
    }

}
