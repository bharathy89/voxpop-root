package com.hackathon.voxpop.activity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.hackathon.voxpop.R;

public class EyeActivity extends BaseActivity {

	private Button postThought;
	private Button takePic;
	private EditText postDescription;
	private EditText stone;
	private EditText wood;
	private EditText volunteers;
	private ImageView mImageView;
	private Bitmap mImageBitmap; 
	File storageDir;
	String mCurrentPhotoPath;
	
	
	private static final int ACTION_TAKE_PHOTO = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eye);
		postDescription = (EditText) findViewById(R.id.insertThought);
		volunteers  = (EditText) findViewById(R.id.volunteerNumber);
		postThought = (Button) findViewById(R.id.postThought);
		storageDir = new File(Environment.getExternalStorageDirectory()+"/voxpop/");
		if(storageDir.exists()==false)
		{
			storageDir.mkdir();
		}
		postThought.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//post the data here;
				Intent gotoVolunteerJobs = new Intent(EyeActivity.this,JobsActivity.class);
				startActivity(gotoVolunteerJobs);
				overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
			}
		});
		
		takePic = (Button) findViewById(R.id.takePic);
		takePic.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dispatchTakePictureIntent(ACTION_TAKE_PHOTO,"ssidgoeshere");
			}
		});
		mImageView = (ImageView) findViewById(R.id.picture);
		
	}
	
	private void dispatchTakePictureIntent(int actionCode,String ssId) {
		File f;
		try {
			f = createImageFile(ssId);
			Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
			startActivityForResult(takePictureIntent, actionCode);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private File createImageFile(String ssId) throws IOException {
	    // Create an image file name
	    String timeStamp = 
	        new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String imageFileName = ssId + timeStamp + "_";
	    File image = new File(storageDir,ssId+System.currentTimeMillis()+".jpg");
	    mCurrentPhotoPath = image.getAbsolutePath();
	    return image;
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
	}
	
	protected void onActivityResult (int requestCode, int resultCode, Intent data) {
		//handleSmallCameraPhoto(data);
		galleryAddPic();
	}
	


	private void handleSmallCameraPhoto(Intent intent) {
		Bundle extras = intent.getExtras();
	    mImageBitmap = (Bitmap) extras.get("data");
	    mImageView.setImageBitmap(mImageBitmap);
	}

	private void galleryAddPic() {
	    File f = new File(mCurrentPhotoPath);
	    Uri contentUri = Uri.fromFile(f);
	    mImageView.setImageURI(contentUri);
	}
	
	@Override
    public void onBackPressed()
    {
    	super.onBackPressed();	
    	overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
