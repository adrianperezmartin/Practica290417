package com.example.adrian.notificacioninicio;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Calendar;

/*
    Se pide crear una app que al iniciar el movil lance una notificacion
    y lleve a un video o foto previamente almacenado en el dispositivo.
 */


public class MainActivity extends AppCompatActivity {

    private void lanzarNotificacionImagen(Bitmap bitmap){

        Log.d("MENSAJE", "ENTRA EN LANZAR NOTIFICACION IMAGEN 1");
        //PREPARO EL ASPECTO DE LA NOTIFICACION
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setContentTitle("Nuevo mensaje");
        builder.setContentText("Imagen");
        //Para eliminar la notiicacion sin tener que borrarla manualmente
        builder.setAutoCancel(true);

        //PROGRAMO EL RETORNO
        //Aqui ire cuando el usuario toque la notificacion
        Intent resultIntent = new Intent(this, NotificationActivity.class);
        resultIntent.putExtra("FOTO", bitmap);

        Log.d("MENSAJE", "ENTRA EN LANZAR NOTIFICACION IMAGEN 2");
        //Envoltorio del intent que se crea para poder acceder desde fuera de la aplicacion
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) System.currentTimeMillis(),resultIntent, PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));

        //LANZAMOS LA NOTIFICACION
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = builder.build();
        notificationManager.notify(350, notification);
        Log.d("MENSAJE", "ENTRA EN LANZAR NOTIFICACION IMAGEN 3");
    }

    private void notificacionDiaSemana(){
        Calendar calendar = Calendar.getInstance();
        int dia = calendar.get(Calendar.DAY_OF_WEEK);
        ImageView imageView = (ImageView) findViewById(R.id.imagen);

        switch (dia){
            case Calendar.MONDAY:
                Log.d("DIA DE LA SEMANA: ", "LUNES");
                InputStream isLunes = this.getResources().openRawResource(R.raw.lunes);
                Bitmap lunes = BitmapFactory.decodeStream(isLunes);
                String pathLunes = "android.resource://"+getPackageName()+"/"+R.raw.lunes;
                Uri uri_imagenLunes = Uri.parse(pathLunes);
                imageView.setImageURI(uri_imagenLunes);
                lanzarNotificacionImagen(lunes);
                break;
            case Calendar.TUESDAY:
                Log.d("DIA DE LA SEMANA: ", "MARTES");
                InputStream isMartes = this.getResources().openRawResource(R.raw.martes);
                Bitmap martes = BitmapFactory.decodeStream(isMartes);
                String pathMartes = "android.resource://"+getPackageName()+"/"+R.raw.martes;
                Uri uri_imagenMartes = Uri.parse(pathMartes);
                imageView.setImageURI(uri_imagenMartes);
                lanzarNotificacionImagen(martes);
                break;
            case Calendar.WEDNESDAY:
                Log.d("DIA DE LA SEMANA: ", "MIERCOLES");
                InputStream isMiercoles = this.getResources().openRawResource(R.raw.miercoles);
                Bitmap miercoles = BitmapFactory.decodeStream(isMiercoles);
                String pathMiercoles = "android.resource://"+getPackageName()+"/"+R.raw.miercoles;
                Uri uri_imagenMiercoles = Uri.parse(pathMiercoles);
                imageView.setImageURI(uri_imagenMiercoles);
                lanzarNotificacionImagen(miercoles);
                break;
            case Calendar.THURSDAY:
                Log.d("DIA DE LA SEMANA: ", "JUEVES");
                InputStream isJueves = this.getResources().openRawResource(R.raw.jueves);
                Bitmap jueves = BitmapFactory.decodeStream(isJueves);
                String pathJueves = "android.resource://"+getPackageName()+"/"+R.raw.jueves;
                Uri uri_imagenJueves = Uri.parse(pathJueves);
                imageView.setImageURI(uri_imagenJueves);
                lanzarNotificacionImagen(jueves);
                break;
            case Calendar.FRIDAY:
                Log.d("DIA DE LA SEMANA: ", "VIERNES");
                InputStream isViernes = this.getResources().openRawResource(R.raw.viernes);
                Bitmap viernes = BitmapFactory.decodeStream(isViernes);
                String pathViernes = "android.resource://"+getPackageName()+"/"+R.raw.viernes;
                Uri uri_imagenViernes = Uri.parse(pathViernes);
                imageView.setImageURI(uri_imagenViernes);
                lanzarNotificacionImagen(viernes);
                break;
            case Calendar.SATURDAY:
                Log.d("DIA DE LA SEMANA: ", "SABADO");
                InputStream isSabado = this.getResources().openRawResource(R.raw.sabado);
                Bitmap sabado = BitmapFactory.decodeStream(isSabado);
                String pathSabado = "android.resource://"+getPackageName()+"/"+R.raw.sabado;
                Uri uri_imagenSabado = Uri.parse(pathSabado);
                imageView.setImageURI(uri_imagenSabado);
                lanzarNotificacionImagen(sabado);
                break;
            case Calendar.SUNDAY:
                Log.d("DIA DE LA SEMANA: ", "DOMINGO");
                InputStream isDomingo = this.getResources().openRawResource(R.raw.domingo);
                Bitmap domingo = BitmapFactory.decodeStream(isDomingo);
                String pathDomingo = "android.resource://"+getPackageName()+"/"+R.raw.domingo;
                Uri uri_imagenDomingo = Uri.parse(pathDomingo);
                imageView.setImageURI(uri_imagenDomingo);
                lanzarNotificacionImagen(domingo);
                break;
        }
    }

    /*private void imagenDiaSemana(){
        ImageView imageView = (ImageView) findViewById(R.id.imagen);
        String path = "android.resource://"+getPackageName()+"/"+R.raw.lunes;
        Uri uri_imagen = Uri.parse(path);
        imageView.setImageURI(uri_imagen);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificacionDiaSemana();
    }
}
