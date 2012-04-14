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

	String trabajador= new String(),genero= new String(),name1 = new String(),
	name2 = new String(),age = new String();	
	EditText nombre,apellidos,edad;
	CheckBox currante;
	RadioButton sexo;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        nombre = (EditText) findViewById(R.id.firstname);
        apellidos = (EditText) findViewById(R.id.lastname);
		edad = (EditText) findViewById(R.id.age);
		currante = (CheckBox) findViewById(R.id.trabajador);
		sexo = (RadioButton) findViewById(R.id.genero);
        
        //INICIO --- Spinner de Paises
        final Spinner spinner = (Spinner) findViewById(R.id.country);
		final ArrayAdapter <CharSequence>adapter = ArrayAdapter.createFromResource(
		this, R.array.array_paises, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		//FIN --- Spinner de Paises		

		final Builder alert = new AlertDialog.Builder(this);
		
		//INICIO --- Button OnClickListener recogida de datos
        Button boton = (Button) findViewById(R.id.guardar);
        boton.setOnClickListener(new OnClickListener() {			
			public void onClick(View clickListener) {
				
				name1 = nombre.getText().toString();
				name2 = apellidos.getText().toString();
				age = edad.getText().toString();
				if (currante.isChecked()==true) 
					trabajador="Trabajador";
				else
					trabajador="";
				if (sexo.isChecked()==true)
					genero = "Masculino";
				else
					genero = "Femenino";
				
				if(name1.equals("")||name2.equals("")||age.equals("")){
					//INICIO --- AlertDialog Campos requeridos
					alert.setTitle("Información Requerida");
					alert.setMessage("Es obligatorio rellenar todos los campos");
					alert.setCancelable(false);
					alert.setNeutralButton("OK",new DialogInterface.OnClickListener() {
						  public void onClick(DialogInterface dialog, int which) {}
						});
					alert.show();
				    //FIN --- AlertDialog Campos requeridos	 
				}else{

				Intent intent=new Intent(VistaBasica2Activity.this.getApplication(), FormularioActivity.class );
				intent.putExtra("n",name1);
				intent.putExtra("a",name2);
				intent.putExtra("p", spinner.getSelectedItem().toString());
				intent.putExtra("e", age);
				intent.putExtra("t", trabajador);
				intent.putExtra("g", genero);
				startActivity(intent);
				}
			}
		});
      //FIN --- Button OnClickListener recogida de datos
    }
    
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		
	}
	
	public void onNothingSelected(AdapterView<?> arg0) {
		
	}
}