package Springboot_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Springboot_Model.User;



@Repository
public interface Userreposotory extends JpaRepository<User, Long>{

  	
	boolean existsByEmail(String email);
	
	
}