package crf.android.vista;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class VistaBasica2Activity extends Activity implements OnItemSelectedListener {

	String trabajador= new String(),genero= new String();
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //INICIO --- Spinner de Paises
        final Spinner spinner = (Spinner) findViewById(R.id.country);
		final ArrayAdapter <CharSequence>adapter = ArrayAdapter.createFromResource(
		this, R.array.array_paises, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		//FIN --- Spinner de Paises
		
		//INICIO --- AlertDialog Campos requeridos
		Builder alert = new AlertDialog.Builder(this);
		alert.setTitle("Información Requerida");
		alert.setMessage("Es obligatorio rellenar todos los campos");
		alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
		  public void onClick(DialogInterface dialog, int which) {
			  //No tengo ni idea de como implementar esta parte de codigo para detectar que todos los campos están rellenados
			  
		  }
		});
		alert.show();
        //FIN --- AlertDialog Campos requeridos
		
		//INICIO --- Button OnClickListener recogida de datos
        Button boton = (Button) findViewById(R.id.guardar);
        boton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View clickListener) {
				EditText nombre = (EditText) findViewById(R.id.firstname);
				String name1 = nombre.getText().toString();
				
				EditText apellidos = (EditText) findViewById(R.id.lastname);
				String name2 = apellidos.getText().toString();
				
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

				Intent intent=new Intent(VistaBasica2Activity.this.getApplication(), FormularioActivity.class );
				intent.putExtra("n",name1);
				intent.putExtra("a",name2);
				intent.putExtra("p", spinner.getSelectedItem().toString());
				intent.putExtra("e", age);
				intent.putExtra("t", trabajador);
				intent.putExtra("g", genero);
				startActivity(intent);
			}
		});
      //FIN --- Button OnClickListener recogida de datos
    }
    
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}
	
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
}