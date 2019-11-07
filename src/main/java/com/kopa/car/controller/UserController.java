package com.kopa.car.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kopa.car.exception.UserNotFoundException;
import com.kopa.car.model.User;
import com.kopa.car.repository.UserRepository;
import com.kopa.car.service.UserService;

@Controller
@RequestMapping("/ap")
public class UserController {
	
	@Autowired
	UserService service;
//	private UserRepository userRepository;
	
//	@RequestMapping(path="/users", method=RequestMethod.GET , produces={"application/json"})
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//	
//	@PostMapping("/add")
//    public User addUser(@Valid @RequestBody User user) throws UserNotFoundException{
//        return userRepository.save(user);
//    }
//	
//	@GetMapping("/users/{uid}")
//    public User getUserById(@PathVariable(value = "uid") Long uid) {
//        return userRepository.findById(uid).get();
//        		//.orElseThrow(() -> new UserNotFoundException(uid));
//                
//    }
//	
//	@DeleteMapping("/users/{uid}")
//	public ResponseEntity<?> deleteUser(@PathVariable(value = "uid") Long uid) throws UserNotFoundException {
//	    User user = userRepository.findById(uid)
//	            .orElseThrow(() -> new UserNotFoundException(uid));
//
//	    userRepository.delete(user);
//
//	    return ResponseEntity.ok().build();
//	}
//	
	
	@RequestMapping
    public String getAllEmployees(Model model) 
    {
        List<User> list = service.getAllEmployees();
 
        model.addAttribute("users", list);
        return "User";
    }
	
	@RequestMapping(path = {"/edit", "/edit/{uid}"})
    public String editEmployeeById(Model model, @PathVariable("uid") Optional<Long> uid) 
                            throws UserNotFoundException 
    {
        if (uid.isPresent()) {
            User entity = service.getEmployeeById(uid.get());
            model.addAttribute("user", entity);
        } else {
            model.addAttribute("user", new User());
        }
        return "AddEditUser";
    }
     
    @RequestMapping(path = "/delete/{uid}")
    public String deleteEmployeeById(Model model, @PathVariable("uid") Long uid) 
                            throws UserNotFoundException 
    {
        service.deleteEmployeeById(uid);
        return "redirect:/";
    }
 
    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public String createOrUpdateEmployee(User employee) 
    {
        service.createOrUpdateEmployee(employee);
        return "redirect:/";
    }
 

}
