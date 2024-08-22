package com.example.exersise19.Controller;

import com.example.exersise19.Api.ApiResponse;
import com.example.exersise19.Model.Course;
import com.example.exersise19.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getAllcourses(){
        return ResponseEntity.status(200).body(courseService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid@RequestBody Course course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("add course success"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id,@Valid@RequestBody Course course){
        courseService.updateCourse(id, course);
        return ResponseEntity.status(200).body(new ApiResponse("update course success"));

    }
    @PutMapping("/{course_id}/assighn/{teacher_id}")
    public ResponseEntity assighn(@PathVariable Integer course_id,@PathVariable Integer teacher_id){
        courseService.assighnTeacherToCourse(course_id,teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("assighn teacher success"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("delete course success"));
    }
    @GetMapping("/get_teacher_name/{course_id}")
    public ResponseEntity getTeacherByCourseId(@PathVariable Integer course_id){
        String name=courseService.getTeacherNameById(course_id);
        return ResponseEntity.status(200).body(name);

    }
}
