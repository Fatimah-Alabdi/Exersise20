package com.example.exersise19.Repository;

import com.example.exersise19.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
Teacher findTeacherById(Integer id);
}
