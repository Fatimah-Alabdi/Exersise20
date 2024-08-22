package com.example.exersise19.Service;

import com.example.exersise19.Api.ApiException;
import com.example.exersise19.Model.Teacher;
import com.example.exersise19.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }
    public void add(Teacher teacher) {
        teacherRepository.save(teacher);

    }
    public void update(Integer id,Teacher teacher) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("teacher not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);

    }
    public void delete(Integer id) {
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1 == null) {
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(teacher1);
    }
    public Teacher getTeacherDetails(Integer id) {
        Teacher t= teacherRepository.findTeacherById(id);
        if (t == null) {
            throw new ApiException("teacher not found");
        }
        return t;

    }
}
