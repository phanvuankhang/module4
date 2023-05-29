package com.example.validate_form_register.repository;

import com.example.validate_form_register.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
