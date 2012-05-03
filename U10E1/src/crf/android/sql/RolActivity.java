package crf.android.sql;

import crf.android.sql.persistencia.Rol;
import crf.android.sql.persistencia.RolManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RolActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText nombre = (EditText) findViewById(R.id.name);
		String name = nombre.getText().toString();
		
		EditText nivel = (EditText) findViewById(R.id.level);
		String level = nombre.getText().toString();
		
		EditText experiencia = (EditText) findViewById(R.id.experience);
		String experience = nombre.getText().toString();
		
		EditText fuerza = (EditText) findViewById(R.id.force);
		String force = nombre.getText().toString();
		
		EditText magia = (EditText) findViewById(R.id.magic);
		String magic = nombre.getText().toString();
        
        Rol rol = new Rol(0,10,50,50);
        RolManager rolManager = new RolManager(this);
        rolManager.createRol(rol);

        Rol database = rolManager.getRolByName("Altair");
        System.out.println("Rol Name "+database.getName());
        
        Button boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//..................
				
			}
		});
    }
}