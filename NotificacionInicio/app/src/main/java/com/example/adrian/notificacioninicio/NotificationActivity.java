package com.example.adrian.notificacioninicio;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Log.d("MENSAJE", "ENTRA EN NOTIFICACION ACTIVITY");
        Bitmap bm = getIntent().getParcelableExtra("FOTO");
        ImageView imageView = (ImageView)findViewById(R.id.imagen);
        imageView.setImageBitmap(bm);

    }
}
