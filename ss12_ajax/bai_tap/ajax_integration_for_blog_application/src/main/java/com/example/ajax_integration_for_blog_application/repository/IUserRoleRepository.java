package com.example.ajax_integration_for_blog_application.repository;


import com.example.ajax_integration_for_blog_application.model.AppUser;
import com.example.ajax_integration_for_blog_application.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByAppUser(AppUser appUser);

}
