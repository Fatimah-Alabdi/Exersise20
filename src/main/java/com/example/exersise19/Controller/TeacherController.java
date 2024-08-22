package com.example.exersise19.Controller;

import com.example.exersise19.Api.ApiResponse;
import com.example.exersise19.Model.Teacher;
import com.example.exersise19.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.findAllTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid@RequestBody Teacher teacher){
        teacherService.add(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@Valid@RequestBody Teacher teacher){
        teacherService.update(id, teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted successfully"));
    }
    @GetMapping("/get_details/{id}")
    public ResponseEntity findAddressByTeacherId(@PathVariable Integer id){

        return ResponseEntity.status(200).body(teacherService.getTeacherDetails(id));
    }
}
