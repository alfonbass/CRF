package crf.android.U7E5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FormularioActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {		
		Persona persona = new Persona();
		Bundle extras = getIntent().getExtras();		
		super.onCreate(savedInstanceState);
		
		String trabajador = new String();
		boolean currante = persona.setTrabajador(extras.getBoolean("t"));
		if (currante==true)
			trabajador = "Trabajador";
		else
			trabajador = "";
		
		/*String firstname=extras.getString("n");
		String lastname=extras.getString("a");
		String country=extras.getString("p");
		String age=extras.getString("e");
		Log.e(firstname, "Nombre :");
		Log.e(lastname, "Apellidos :");
		Log.e(country, "Pais :");
		Log.e(age, "Edad :");*/	
		
		LinearLayout linear = new LinearLayout(this);
		linear.setOrientation(LinearLayout.VERTICAL);
		TextView text1 = new TextView(this);
		TextView text2 = new TextView(this);
		TextView text3 = new TextView(this);
		TextView text4 = new TextView(this);
		TextView text5 = new TextView(this);
		TextView text6 = new TextView(this);
		text1.setText(extras.getString("n"));
		text2.setText(extras.getString("a"));
		text3.setText(extras.getString("p"));
		text4.setText(extras.getInt("e"));
		text5.setText(trabajador);
		text6.setText(extras.getString("g"));
		linear.addView(text1);
		linear.addView(text2);
		linear.addView(text3);
		linear.addView(text4);
		linear.addView(text5);
		linear.addView(text6);
		setContentView(linear); 
	}
}