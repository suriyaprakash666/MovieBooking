package com.altimetrik.moviebooking.repository;

import com.altimetrik.moviebooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
