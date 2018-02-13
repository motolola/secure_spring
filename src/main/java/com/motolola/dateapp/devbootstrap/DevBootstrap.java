package com.motolola.dateapp.devbootstrap;


import java.util.Arrays;
import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.motolola.dateapp.models.Preference;
import com.motolola.dateapp.models.PreferenceRepository;
import com.motolola.dateapp.models.Role;
import com.motolola.dateapp.models.RoleRepository;
import com.motolola.dateapp.models.User;
import com.motolola.dateapp.models.UserRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	

	private UserRepository userRepo;
	private RoleRepository roleRepo;
	private PreferenceRepository preferenceRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public DevBootstrap(UserRepository userRepo, RoleRepository roleRepo, PreferenceRepository preferenceRepository) {
		this.userRepo = userRepo;
		this.roleRepo = roleRepo;
		this.preferenceRepository = preferenceRepository;
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
		
		/*
		 * SET INITIAL PREFERENCES FOR USERS
		 * 
		 */
		//delete if data in table ..
		preferenceRepository.deleteAll();
		
		String[] userPreferences = 
			{"Straight Men",
					"Straight Women",
					"Gay Men", 
					"Lesbian Women",
					"Couple",
					"Bi Couple",
					"Bi Men",
					"Bi Women",
					"Trans Women",
					"Trans Men"};
		
		for (int i = 0; i < userPreferences.length; i++) {
			preferenceRepository.save(new Preference(userPreferences[i], "No Description"));
		}
		
		//get any preference ...
		//List<Preference> preference = preferenceRepository.findAll();
		//System.out.println(preference.toString());
		
		//create Preference for the two Users ... 
		//User user100 = userRepo.findByEmail("motolola@icloud.com");
		//for (Preference pref : preference) {
		//	user100.getPreferences().addAll(preference);
			//userRepo.save(user100);
		//}
		//user100.getPreferences().add(e)
		
		
		
		System.out.println(" ....... Initial Data Loaded ............");
	
	}

}
