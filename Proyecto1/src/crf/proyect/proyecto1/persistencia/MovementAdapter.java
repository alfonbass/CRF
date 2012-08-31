package crf.proyect.proyecto1.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class MovementAdapter {
	public static final String KEY_ID = "id";
	public static final String KEY_TYPE ="tipo";
	public static final String KEY_CANT = "cantidad";
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	private static final String MOVEMENT_TABLE = "Move";
	static final String DATABASE_CREATE = "create table movement (id text primary key,"
			+"KEY_ID not null,"
			+"KEY_TYPE not null,"
			+"KEY_CANT not null,);";
	
	private final Context context;
	
	public MovementAdapter(Context cntxt) {
	      this.context = cntxt;
	      databaseHelper = new DatabaseHelper(context);
	      database = databaseHelper.getWritableDatabase();
	}
	
	public void close() {
		databaseHelper.close();
	}
	
	public long createMovement(ContentValues initialValues) {
	      return database.insert(MOVEMENT_TABLE, null, initialValues);
	}
	
	public boolean deleteMovement(long rowId) {
	      return database.delete(MOVEMENT_TABLE, KEY_ID + "=" + rowId, null) > 0;
	}
	public Cursor fetchMovement(int id) throws SQLException {
		Cursor mCursor = database.rawQuery("Select * from "+MOVEMENT_TABLE+ " where "+KEY_ID+ " = " +id, null);
	    if (mCursor != null) {
	    	mCursor.moveToFirst();
	    }
	    return mCursor;
	}
	
	public boolean updateMovement(long rowId, ContentValues values) {
	      return database.update(MOVEMENT_TABLE, values, KEY_ID + "=" + rowId, null) > 0;//posible fallo
	}

}
