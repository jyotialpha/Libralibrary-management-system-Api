package com.management.library.dao;

import java.util.List;

import com.management.library.model.Admin;

public interface Admindao {
	int save(Admin admin);
    List<Admin> findAll();
    int update(Admin admin);
    int delete(Long adminId);

}
