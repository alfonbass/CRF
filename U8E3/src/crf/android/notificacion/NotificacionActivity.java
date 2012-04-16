package crf.android.notificacion;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NotificacionActivity extends Activity {
	
	NotificationManager notificationM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	int NOTIFICATION_ID = 1;
	int iconToShowInNotification = R.drawable.ic_launcher;
	long timeInMilis = System.currentTimeMillis();
	CharSequence notificationMessage = "Ha pulsado el boton de notificación";
	Notification notification = new Notification(iconToShowInNotification, notificationMessage, timeInMilis);
	
	Intent notificationIntent = new Intent(this, NotificacionActivity.class);
	PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
	
	Builder alert = new AlertDialog.Builder(this);
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button boton = (Button) findViewById(R.id.boton);
        boton.setOnClickListener(new OnClickListener() {			
			public void onClick(View clickListener) {
				notificationM.notify(NOTIFICATION_ID, notification);
				alert.setTitle("AlertDialog");
				alert.setMessage("¿Quiere cerrar la aplicación?");
				alert.setCancelable(false);
				alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int which) {
						  notificationM.cancel(NOTIFICATION_ID);
						  
					  }
					});
				alert.setNegativeButton("No",  new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int which) {
						  notificationM.cancel(NOTIFICATION_ID);
					      setContentView(R.layout.main);
					  }
					});
				alert.show();
			}
		});
    }
}