package com.gl.practice.download;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private Button mDownloadButton;
    private ImageView mDownloadImage;
    private ProgressDialog mProgressDialog;
    private String url;
    private Bitmap mImageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDownloadButton = findViewById(R.id.button_download);
        mDownloadImage = findViewById(R.id.image_download);
        url = "https://raw.githubusercontent.com/hitesh-bhengra/Assignments/Day-7-AsyncTask/Counter%20Strike%20Global%20Offensive.jpg";
        mDownloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask download = new DownloadTask();
                download.execute(url);
            }
        });

    }

    class DownloadTask extends AsyncTask<String,Integer,Bitmap> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setMessage("Please Wait");
            mProgressDialog.setCancelable(false);
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                InputStream mInput = new URL(url).openStream();
                mImageBitmap = BitmapFactory.decodeStream(mInput);

            } catch (Exception e) {
                //Toast.makeText(MainActivity.this,"Image Not Found",Toast.LENGTH_SHORT).show();
            }
            return mImageBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mDownloadImage.setImageBitmap(bitmap);
            mProgressDialog.dismiss();
        }
    }
}
