package crf.proyect.proyecto1;

import crf.proyect.proyecto1.persistencia.Category;
import crf.proyect.proyecto1.persistencia.CategoryManager;
import crf.proyect.proyecto1.persistencia.Count;
import crf.proyect.proyecto1.persistencia.CountManager;
import crf.proyect.proyecto1.persistencia.Movement;
import crf.proyect.proyecto1.persistencia.MovementManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Spinner sDatos = (Spinner) findViewById(R.id.spinnermain);        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this, R.array.datos , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sDatos.setAdapter(adapter);
        
        Category category = new Category(1,"Tecnologia");
        Count count = new Count(1,"VISA", 1000);
        Movement movement = new Movement(1,1,1,"ingreso", 550);
        
        CategoryManager categoryManager = new CategoryManager(this);
        CountManager countManager = new CountManager(this);
        MovementManager movementManager = new MovementManager(this);
        
        categoryManager.createCategory(category);
        countManager.createCount(count);
        movementManager.createMovement(movement);
        
        Movement database = MovementManager.getMovementById(1);
        
        System.out.println("Categoria ID "+database.getId_Categoria());
        System.out.println("Cuenta ID "+database.getId_Cuenta());
        System.out.println("Movimiento ID "+database.getId()+"Tipo de Transacción: "+database.getType()+"Cantidad: "+database.getCant());
    }
}
