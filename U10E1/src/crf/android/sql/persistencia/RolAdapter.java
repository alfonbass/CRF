package crf.android.sql.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RolAdapter {
	public static final String KEY_NAME ="nombre";
	public static final String KEY_LEVEL = "nivel";
	public static final String KEY_XP = "experiencia";
	public static final String KEY_FR = "fuerza";
	public static final String KEY_MG = "magia";
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	private static final String ROL_TABLE = "roles";
	static final String DATABASE_CREATE = "create table roles (name text primary key,"
			+"KEY_LEVEL not null,"
			+"KEY_XP not null,"
			+"KEY_FR not null,"
			+"KEY_MG not null,);";
	
	private final Context context;
	
	public RolAdapter(Context cntxt) {
	      this.context = cntxt;
	      databaseHelper = new DatabaseHelper(context);
	      database = databaseHelper.getWritableDatabase();
	}
	
	public void close() {
		databaseHelper.close();
	}
	
	public long createRol(ContentValues initialValues) {
	      return database.insert(ROL_TABLE, null, initialValues);
	}
	
	public boolean deleteRol(long rowName) {
	      return database.delete(ROL_TABLE, KEY_NAME + "=" + rowName, null) > 0;
	}
	public Cursor fetchRol(String rowName) throws SQLException {
		Cursor mCursor = database.rawQuery("Select * from "+ROL_TABLE+ " where "+KEY_NAME+ " = " +rowName, null);
	    if (mCursor != null) {
	    	mCursor.moveToFirst();
	    }
	    return mCursor;
	}
	
	public boolean updateRol(long rowName, ContentValues values) {
	      return database.update(ROL_TABLE, values, KEY_NAME + "=" + rowName, null) > 0;//posible fallo
	}
}