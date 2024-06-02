package com.management.library.dao;

import com.management.library.model.Student;

public interface Studentdao {
	int save(Student student);
    Student findById(Long studentId);
    int update(Student student);
    int delete(Long studentId);
}
