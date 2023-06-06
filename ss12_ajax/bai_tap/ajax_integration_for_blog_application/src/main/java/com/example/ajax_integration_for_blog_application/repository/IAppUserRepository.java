package com.example.ajax_integration_for_blog_application.repository;


import com.example.ajax_integration_for_blog_application.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUserName(String username);
}
