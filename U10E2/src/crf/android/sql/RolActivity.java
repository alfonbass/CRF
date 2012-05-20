package crf.android.sql;

import crf.android.sql.persistencia.Rol;
import crf.android.sql.persistencia.RolManager;
import android.app.Activity;
import android.os.Bundle;

public class RolActivity extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        
        Rol rol = new Rol(1,"Altair",10,50,50,40);
        RolManager rolManager = new RolManager(this);
        rolManager.createRol(rol);

        Rol database = rolManager.getRolById(1);
        System.out.println("Rol ID "+database.getId());
    }
}