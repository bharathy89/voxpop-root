package com.hackathon.voxpop.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hackathon.voxpop.R;

public class SignUpActivity extends BaseActivity {
	
	private TextView name;
	private TextView email;
	private TextView password;
	private Button signup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		name = (TextView) findViewById(R.id.signname);
		email = (TextView) findViewById(R.id.signuname);
		password = (TextView) findViewById(R.id.signpassword);
		signup = (Button) findViewById(R.id.signupButton);
		
		signup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}

}
