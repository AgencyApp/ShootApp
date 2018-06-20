package com.theshootapp.world;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.otaliastudios.cameraview.CameraUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class PictureDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_frame);
        Intent i=getIntent();
        String path=i.getStringExtra("image");
        File imgFile = new  File(path);

        if(imgFile.exists()) {
            byte[] b = new byte[(int) imgFile.length()];
            try {
                FileInputStream fileInputStream = new FileInputStream(imgFile);
                fileInputStream.read(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            final ImageView myImage = (ImageView) findViewById(R.id.imageView);

           // myImage.setImageBitmap(myBitmap);
            CameraUtils.decodeBitmap(b, new CameraUtils.BitmapCallback() {
                @Override
                public void onBitmapReady(Bitmap bitmap) {
                    myImage.setImageBitmap(bitmap);
                }
            });


        }
    }
}
