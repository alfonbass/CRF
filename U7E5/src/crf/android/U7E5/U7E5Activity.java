package crf.android.U7E5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class U7E5Activity extends Activity {

	String trabajador= new String(),genero= new String();

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
		
        
        Button boton = (Button) findViewById(R.id.guardar);
        boton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View clickListener) {
				Persona persona = new Persona();
				
				EditText nombre = (EditText) findViewById(R.id.firstname);
				String name1 = nombre.getText().toString();
				
				EditText apellidos = (EditText) findViewById(R.id.lastname);
				String name2 = apellidos.getText().toString();
				
				EditText pais = (EditText) findViewById(R.id.country);
				String country = pais.getText().toString();
				
				EditText edad = (EditText) findViewById(R.id.age);
				String age = edad.getText().toString();
				
				CheckBox currante = (CheckBox) findViewById(R.id.trabajador);
				if (currante.isChecked()==true) 
					trabajador="Trabajador";
				else
					trabajador="";
				
				RadioButton sexo = (RadioButton) findViewById(R.id.genero);
				if (sexo.isChecked()==true)
					genero = "Masculino";
				else
					genero = "Femenino";

				Intent intent=new Intent(U7E5Activity.this.getApplication(), FormularioActivity.class );
				intent.putExtra("n",persona.getNombre());
				intent.putExtra("a",persona.getApellido());
				intent.putExtra("p", persona.getPais());
				intent.putExtra("e", persona.getEdad());
				intent.putExtra("t", persona.getTrabajador());
				intent.putExtra("g", persona.getGenero());
				startActivity(intent);
			}
		});
    }
}