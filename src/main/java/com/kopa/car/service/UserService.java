package com.kopa.car.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopa.car.exception.UserNotFoundException;
import com.kopa.car.model.User;
import com.kopa.car.repository.UserRepository;

@Service
public class UserService {
     
    @Autowired
    UserRepository repository;
     
    public List<User> getAllEmployees()
    {
        List<User> result = (List<User>) repository.findAll();
         
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<User>();
        }
    }
     
    public User getEmployeeById(Long uid) throws UserNotFoundException 
    {
        Optional<User> employee = repository.findById(uid);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new UserNotFoundException("No employee record exist for given id");
        }
    }
     
    public User createOrUpdateEmployee(User entity) 
    {
        if(entity.getId()  == null) 
        {
            entity = repository.save(entity);
             
            return entity;
        } 
        else
        {
            Optional<User> employee = repository.findById(entity.getId());
             
            if(employee.isPresent()) 
            {
                User newEntity = employee.get();
                newEntity.setEmail(entity.getEmail());
                newEntity.setFirst_name(entity.getFirst_name());
                newEntity.setLast_name(entity.getLast_name());
 
                newEntity = repository.save(newEntity);
                 
                return newEntity;
            } else {
                entity = repository.save(entity);
                 
                return entity;
            }
        }
    } 
     
    public void deleteEmployeeById(Long uid) throws UserNotFoundException 
    {
        Optional<User> employee = repository.findById(uid);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(uid);
        } else {
            throw new UserNotFoundException("No employee record exist for given id");
        }
    } 

}
