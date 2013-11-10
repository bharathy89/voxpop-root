package com.hackathon.voxpop.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.hackathon.voxpop.R;

public class MenuActivity extends Activity {

	private Button mouth;
	private Button ear;
	private Button eye;
	private Button hand;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		mouth = (Button) findViewById(R.id.mouth);
		mouth.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent postIntent = new Intent(MenuActivity.this, PostListActivity.class);
				startActivity(postIntent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			}
		});
		eye = (Button) findViewById(R.id.eye);
		eye.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stubIntent gotoVolunteerJobs = new Intent(EyeActivity.this,JobsActivity.class);
				
				Intent eyeIntent = new Intent(MenuActivity.this, EyeActivity.class);	
				startActivity(eyeIntent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			}
		});
		ear = (Button) findViewById(R.id.ear);
		ear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent earIntent = new Intent(MenuActivity.this, EarActivity.class);
				//startActivity(earIntent);
			}
		});
		
		hand = (Button) findViewById(R.id.palm);
		hand.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent jobsIntent = new Intent(MenuActivity.this, JobsActivity.class);
				startActivity(jobsIntent);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			}
		});
		
	}

}
