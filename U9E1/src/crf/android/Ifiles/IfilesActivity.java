package crf.android.Ifiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.content.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IfilesActivity extends Activity {
	
	String filename = "file.txt";
	private ContextWrapper context;
	FileOutputStream fileOutputStream;
	EditText string = (EditText) findViewById(R.id.texto);
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {	
				
		        try {
		            fileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND);
		            fileOutputStream.write(string.getText().toString().getBytes());
		            fileOutputStream.close();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }				
			}
		});
        Button obtener = (Button) findViewById(R.id.obtener);
        obtener.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
				String contenido = "";
				FileInputStream fileInputStream;
				try {
				    fileInputStream = context.openFileInput(filename);
				    byte [] InBuf = new byte[fileInputStream.available()];
				    fileInputStream.read(InBuf);
				    contenido = new String(InBuf);
				} catch (FileNotFoundException e) {
				    e.printStackTrace();
				} catch (IOException e) {
				    e.printStackTrace();
				}
				//Puede haber fallo porque context esté vacio
				Toast.makeText(context, contenido, Toast.LENGTH_LONG);
			}
        });
    }
}