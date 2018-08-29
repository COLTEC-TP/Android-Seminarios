package com.grupo.appnotificao;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private static final int mId = 600; //Constante aleatória para id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_simples = (Button) findViewById(R.id.btn_simple);
        btn_simples.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Notification.Builder mBuilder =
                        new Notification.Builder(MainActivity.this)
                                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setContentTitle("My notification")
                                .setContentText("Hello World!");

                Intent rIntent = new Intent(MainActivity.this, Main2Activity.class);
                TaskStackBuilder sBuilder = TaskStackBuilder.create(MainActivity.this);
                sBuilder.addParentStack(Main2Activity.class);
                sBuilder.addNextIntent(rIntent);
                PendingIntent rPendingIntent = sBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(rPendingIntent);

                mBuilder.setAutoCancel(true); //Excluir automaticamente quando clicar

                NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(mId, mBuilder.build());

            }
        });
    }
}
