package com.example.exersise19.Service;

import com.example.exersise19.Api.ApiException;
import com.example.exersise19.Model.Course;
import com.example.exersise19.Model.Teacher;
import com.example.exersise19.Repository.CourseRepository;
import com.example.exersise19.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Integer id, Course course) {
        Course findCourse = courseRepository.findCourseById(id);
        if (findCourse == null) {
            throw new ApiException("Course not found");
        }
        findCourse.setName(course.getName());
        courseRepository.save(findCourse);
    }

    public void deleteCourse(Integer id) {
        Course findCourse = courseRepository.findCourseById(id);
        if (findCourse == null) {
            throw new ApiException("Course not found");
        }
        courseRepository.delete(findCourse);
    }

    public void assighnTeacherToCourse(Integer course_id, Integer teacher_id) {
        Course course1 = courseRepository.findCourseById(course_id);
        if (course1 == null) {
            throw new ApiException("Course not found");
        }
        Teacher teacher1 = teacherRepository.findTeacherById(teacher_id);
        if (teacher1 == null) {
            throw new ApiException("Teacher not found");
        }
        course1.setTeacher(teacher1);
        courseRepository.save(course1);

    }
    public String getTeacherNameById(Integer course_id) {
        Course course1 = courseRepository.findCourseById(course_id);
        if (course1 == null) {
            throw new ApiException("Course not found");
        }
       return course1.getTeacher().getName();



    }
}