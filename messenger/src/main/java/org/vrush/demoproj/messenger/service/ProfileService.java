package org.vrush.demoproj.messenger.service;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.vrush.demoproj.messenger.database.DatabaseClass;
import org.vrush.demoproj.messenger.model.Profile;

public class ProfileService {
	
	private static Map<String,Profile> profiles =  DatabaseClass.getProfiles();
	

	public ProfileService() {
		profiles.put("Vrushab",new Profile(1L,"Vrushab","Y","Bayas"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String  profileName) {
		
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		
		return profiles.remove(profileName);
	}

}
