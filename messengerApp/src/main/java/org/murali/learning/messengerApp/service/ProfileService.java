package org.murali.learning.messengerApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.murali.learning.messengerApp.databaseStub.DatabaseClass;
import org.murali.learning.messengerApp.model.Profile;

public class ProfileService {
	Map<String, Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Murali", new Profile(1L,"Murali","Tiwari","Murali"));
		profiles.put("Vipin", new Profile(2L,"Vipin","Tiwari","Vipin"));
	}
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
		
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	
	}
	public Profile addProfile(Profile profile){
		 profile.setId(profiles.size()+1L);
		 profiles.put(profile.getProfileName(), profile);
		 return profile;
	}
	public Profile updateProfile(Profile profile){
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		 profiles.put(profile.getProfileName(), profile);
		 return profile;
				
	}
	public Profile deleteProfile(String profileName){
		return profiles.remove(profileName);
		
	}
}
