package crf.proyect.proyecto1.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class MovementManager {
	MovementAdapter movementAdapter;

    public MovementManager(Context context){
    	movementAdapter = new MovementAdapter(context);
    }

    public long createMovement(Movement movement){
      ContentValues movementContentValues = convertMovementInContentValues(movement);
      return movementAdapter.createMovement(movementContentValues);
    }

    public Movement getMovementById(int id){
      Cursor movementCursor = movementAdapter.fetchMovement(id);
      return convertCursorInMovement(movementCursor);
    }

    private ContentValues convertMovementInContentValues(Movement movement) {
      ContentValues contentValues = new ContentValues();
      contentValues.put(MovementAdapter.KEY_ID, movement.getId());
      contentValues.put(MovementAdapter.KEY_TYPE, movement.getType());
      contentValues.put(MovementAdapter.KEY_CANT, movement.getCant());
      return contentValues;
    }

    private Movement convertCursorInMovement(Cursor cursor) {
    	Movement movement = new Movement();
    	movement.setId(cursor.getInt(cursor.getColumnIndex(MovementAdapter.KEY_ID)));
    	movement.setType(cursor.getString(cursor.getColumnIndex(MovementAdapter.KEY_TYPE)));
    	movement.setCant(cursor.getInt(cursor.getColumnIndex(MovementAdapter.KEY_CANT)));
      cursor.close();
      return movement;
    }
}
