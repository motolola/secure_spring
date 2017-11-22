package com.motolola.security.devbootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.motolola.security.models.Role;
import com.motolola.security.models.RoleRepository;
import com.motolola.security.models.User;
import com.motolola.security.models.UserRepository;

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
		User user1 = new User("motolola@icloud.com", bCryptPasswordEncoder.encode("password"), "Motolola", "Agboola", 1);
		Role role1 = new Role("ADMIN");
		
		user1.getRoles().add(role1);
		role1.getUsers().add(user1);
		
		
		roleRepo.save(role1);
		userRepo.save(user1);
		
		

		//user2
		User user2 = new User("atilola@icloud.com",bCryptPasswordEncoder.encode("password"), "Atilola", "Agboola", 1);
		System.out.println(bCryptPasswordEncoder.encode("password"));
		Role role2 = new Role("NORMAL");
		
		user2.getRoles().add(role2);
		role2.getUsers().add(user2);
		
		userRepo.save(user2);
		roleRepo.save(role1);
		
		
		System.out.println(" ....... Initial Data Loaded ............");
	
	}

}
