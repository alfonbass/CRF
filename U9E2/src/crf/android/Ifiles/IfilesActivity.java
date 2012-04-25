package crf.android.Ifiles;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IfilesActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final String filename = "file.txt";
    	final Context context = this;
    	final SharedPreferences preferencia = null;
    	final EditTextPreference editTextPreference= 
        
        Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {	
				
				SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
				SharedPreferences.Editor editor = preferencia.edit();
				editor.putString(filename,"valor_a_guardar");
				editor.commit();
		        Toast.makeText(context, "Guardado", Toast.LENGTH_LONG).show();
			}
		});
        Button obtener = (Button) findViewById(R.id.obtener);
        obtener.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				String contenido = "";
				/*FileInputStream fileInputStream;
				try {
				    fileInputStream = context.openFileInput(filename);
				    byte [] InBuf = new byte[fileInputStream.available()];
				    fileInputStream.read(InBuf);
				    contenido = new String(InBuf);
				} catch (FileNotFoundException e) {
				    e.printStackTrace();
				} catch (IOException e) {
				    e.printStackTrace();
				}*/
				Toast.makeText(context, contenido, Toast.LENGTH_LONG).show();
			}
        });
    }
}