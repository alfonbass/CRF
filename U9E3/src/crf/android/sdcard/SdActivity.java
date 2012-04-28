package crf.android.sdcard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SdActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                
        String state = Environment.getExternalStorageState();
        Context context = this;
        File imagen = new File("/mnt/sdcard/Android/data/crf.android.sdcard/files/Download/", "17209831951787883743.png");
        //File imagen = new File(context.getExternalFilesDir (Environment.DIRECTORY_DOWNLOADS), "17209831951787883743.png");
        //ImageView background = (ImageView) findViewById(R.id.imagen);
        //background.setImageURI(Uri.fromFile(imagen));
        //background.setScaleType(ScaleType.FIT_XY);
        if (Environment.MEDIA_MOUNTED.equals(state)) {			
        	try {
        	    InputStream inputStream = context.getResources().openRawResource(R.drawable.ic_launcher);
        	    OutputStream outputStream = new FileOutputStream(imagen);
        	    byte[] data = new byte[inputStream.available()];
        	    inputStream.read(data);
        	    outputStream.write(data);
        	    inputStream.close();
        	    outputStream.close();
        	} catch (IOException e) {
        	    Log.w("ExternalStorage", "Error writing " + imagen, e);
        	}
        	Log.e(state, "La unidad está montada");
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
        	Log.e(state, "Está montada en modo lectura sólo");        	
        } else if (Environment.MEDIA_REMOVED.equals(state)) {
        	Log.e(state, "La unidad ha sido extraida");
        } else if (Environment.MEDIA_UNMOUNTED.equals(state)) {
            Log.e(state, "La unidad no está montada");
        }
    }
}