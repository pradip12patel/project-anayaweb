package Springboot_ServiceIMPL;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Springboot_Model.User;
import Springboot_Repository.Userreposotory;





@Service
public class userservie  {
	
          @Autowired
	    private Userreposotory userRepository;

   
	

	    public String registerUser(User signupRequest) {
	        // Check if email already exists
	        if (userRepository.existsByEmail(signupRequest.getEmail())) {
	        	
	            return "Email already in use!";
	        }

	        // Create new user and encode password
	        User user = new User();
	        user.setName(signupRequest.getName());
	        user.setEmail(signupRequest.getEmail());
	        user.setDob(signupRequest.getDob());
	        user.setId(signupRequest.getId());
	        user.setPassword(signupRequest.getPassword());
	        user.setPhone(signupRequest.getPhone());

	        // Save user to the database
	        userRepository.save(user);

	        return "User registered successfully!";
	    }


    
	    
	   


}

