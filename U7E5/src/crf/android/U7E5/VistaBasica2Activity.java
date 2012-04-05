package crf.android.U7E5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class VistaBasica2Activity extends Activity implements Parcelable{
	EditText nombre = (EditText) findViewById(R.id.firstname);
	String name1 = nombre.getText().toString();
	
	EditText apellidos = (EditText) findViewById(R.id.lastname);
	String name2 = apellidos.getText().toString();
	
	EditText pais = (EditText) findViewById(R.id.country);
	String country = pais.getText().toString();
	
	EditText edad = (EditText) findViewById(R.id.age);
	String age = edad.getText().toString();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button boton = (Button) findViewById(R.id.guardar);
        boton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View clickListener) {				
				
				Intent intent=new Intent(VistaBasica2Activity.this.getApplication(), FormularioActivity.class );
				intent.putExtra("n",name1);
				intent.putExtra("a",name2);
				intent.putExtra("p", country);
				intent.putExtra("e", age);
				startActivity(intent);
			}
		});
    }
	public int describeContents() {
		return 0;
	}
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name1);
		dest.writeString(name2);
		dest.writeString(country);
		dest.writeString(age);
	}
	public void readToParcel(Parcel dest){
		name1=dest.readString();
		name2=dest.readString();
		country=dest.readString();
		age=dest.readString();
	}
	public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {
		public MyParcelable createFromParcel(Parcel in){
			return new MyParcelable(in);
		}
		public MyParcelable[] newArray(int size) {
			return new MyParcelable[size];
		}
	};
}