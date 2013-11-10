package com.hackathon.voxpop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.hackathon.voxpop.activity.MenuActivity;

import com.hackathon.voxpop.R;
import com.parse.ParseAnalytics;

public class LoginActivity extends Activity {
	private Button loginButton;
	private Button registerButton;
	  
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ParseAnalytics.trackAppOpened(getIntent());	
		loginButton = (Button) findViewById(R.id.login);
		loginButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent menuIntent = new Intent(LoginActivity.this, MenuActivity.class);
				startActivity(menuIntent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			}
		});
		
		registerButton = (Button) findViewById(R.id.register);
		registerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent registerIntent = new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(registerIntent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
				
			}
		});
	}
	
}
