package com.example.adrian.notificacioninicio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DespertarReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("MENSAJE", "EL TELEFONO SE ENCEDERA");
        //Aqui tendremos que lanzar la actividad

        Intent intent1 = new Intent(context, MainActivity.class);
        //Solo asi puedo lanzar la actividad desde fuera del contexto
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
    }
}
