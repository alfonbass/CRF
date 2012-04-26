package crf.android.Ifiles;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

public class IfilesActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText string = (EditText) findViewById(R.id.texto);
    	final Context context = this;
        
        Button guardar = (Button) findViewById(R.id.guardar);
        guardar.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {	
				String text=string.getText().toString();

				SharedPreferences sharedpreferences = getSharedPreferences("datos", MODE_PRIVATE);
				SharedPreferences.Editor editor = sharedpreferences.edit();
				editor.putString("texto",text );
				editor.commit();
		        Toast.makeText(context, "Guardado", Toast.LENGTH_LONG).show();
			}
		});
        Button obtener = (Button) findViewById(R.id.obtener);
        obtener.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {				
				SharedPreferences sharedpreferences = getSharedPreferences("datos", MODE_PRIVATE);
				String text = sharedpreferences.getString("texto", "No se ha encontrado nada");
				Toast.makeText(context, text, Toast.LENGTH_LONG).show();
			}
        });
    }
}