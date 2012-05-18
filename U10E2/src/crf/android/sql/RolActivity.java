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
        
        Rol rol = new Rol(1,"Ezio",10,50,50,40, 100, 110);
        RolManager rolManager = new RolManager(this);
        rolManager.updateRol(rol);

        Rol database = rolManager.getRolById(1);
        System.out.println("Rol ID "+database.getId());
    }
}