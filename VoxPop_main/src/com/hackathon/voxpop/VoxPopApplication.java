package com.hackathon.voxpop;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;

public class VoxPopApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
		Parse.initialize(this, "b6VmJr9sfBHEloxMgHef1Yo13SV9hTUDsHE5gKfR", 
			"c0tVrVSujd1TEpLeCLyq4GkeuP3a3doYNZJZztjJ");


		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		
		ParseACL.setDefaultACL(defaultACL, true);
	}

}
