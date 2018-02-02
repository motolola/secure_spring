package com.motolola.dataapp.devbootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.motolola.dateapp.models.Role;
import com.motolola.dateapp.models.RoleRepository;
import com.motolola.dateapp.models.User;
import com.motolola.dateapp.models.UserRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	

	private UserRepository userRepo;
	private RoleRepository roleRepo;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
	
	
	
	public DevBootstrap(UserRepository userRepo, RoleRepository roleRepo) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
        buildData();		
	}

	private void buildData()
	{
		System.out.println(" .......Loading Initial Data ............");
		
		//user1
		//get the user with the email first ...
		String email1 = "motolola@icloud.com";
		User tempUser1 = userRepo.findByEmail(email1);
		if (tempUser1 == null) {
			
		//User user1 = new User(email1, bCryptPasswordEncoder.encode("password"), "Motolola", "Agboola", 1);
		User user1 = new User(email1, bCryptPasswordEncoder.encode("password"), "Motolola", "Agboola", "motoboy", "SE15 6JM", 1);	
		Role role1 = new Role("ADMIN");
		
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		
		
		roleRepo.save(role1);
		userRepo.save(user1);
		}
		
		

		//user2
		//get the user with the email first ...
		String email2 = "atilola@icloud.com";
		User tempUser2 = userRepo.findByEmail(email2);
		if (tempUser2 == null) {
		//User user2 = new User(email2,bCryptPasswordEncoder.encode("password"), "Atilola", "Agboola", 1);
		User user2 = new User(email2, bCryptPasswordEncoder.encode("password"), "Atilola", "Agboola", "atigirl", "SE15 6JM", 1);	
		System.out.println(bCryptPasswordEncoder.encode("password"));
		Role role2 = new Role("NORMAL");
		
		user2.getRoles().add(role2);
		role2.getUsers().add(user2);
		
		userRepo.save(user2);
		roleRepo.save(role2);
		}
		
		
		System.out.println(" ....... Initial Data Loaded ............");
	
	}

}
