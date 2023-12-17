package com.example.picquote2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;


public class MainActivity extends AppCompatActivity {
    private static final int IMAGE_RESULT = 1;
    private ImageView imageToUpload;
    private Button uploadImage;
    private Button quoteMe;
    private EditText name;
    private TextView nameQuote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameQuote = (TextView) findViewById(R.id.nameQuote);
        uploadImage = (Button) findViewById(R.id.btnUploadPic);
        imageToUpload = (ImageView) findViewById(R.id.imageToUpload);
        quoteMe = (Button) findViewById(R.id.btnGetQuote);
        name = (EditText) findViewById(R.id.enterName);
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(MainActivity.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                        .start();
            }
        });
        quoteMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameQuote.setText("Hello " + name.getText() +", " + QuoteGenerator.getRandomQuote() );
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        imageToUpload.setImageURI(uri);
        }


}