package crf.android.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MenuActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    }
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
  	}
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    		case R.id.guardar:
    			Toast.makeText(getApplicationContext(),"Guardar",Toast.LENGTH_SHORT).show();
    	        return true;
    	    case R.id.eliminar:
    	        Toast.makeText(getApplicationContext(),"Eiminar",Toast.LENGTH_SHORT).show();
    	        return true;
    	    case R.id.opciones:
     	        Toast.makeText(getApplicationContext(),"Opciones",Toast.LENGTH_SHORT).show();
     	        return true;
    	    case R.id.ayuda:
     	        Toast.makeText(getApplicationContext(),"Ayuda",Toast.LENGTH_SHORT).show();
     	        return true;
    	    case R.id.salir:
     	        Toast.makeText(getApplicationContext(),"Salir",Toast.LENGTH_SHORT).show();
     	        return true;
    	    default:
    	        return super.onOptionsItemSelected(item);
    	}
    }
}