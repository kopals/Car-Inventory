package com.kopa.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kopa.car.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
 
}