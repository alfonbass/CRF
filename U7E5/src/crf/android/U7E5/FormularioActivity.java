package crf.android.U7E5;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FormularioActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		Bundle extras = getIntent().getExtras();		
		super.onCreate(savedInstanceState);
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
		text1.setText(firstname);
		text2.setText(lastname);
		text3.setText(country);
		text4.setText(age);
		linear.addView(text1);
		linear.addView(text2);
		linear.addView(text3);
		linear.addView(text4);
		setContentView(linear); 
	}
}