package crf.android.sql.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RolAdapter {
	public static final String KEY_ID = "id";
	public static final String KEY_NAME ="name";
	public static final String KEY_LEVEL = "nivel";
	public static final String KEY_XP = "experiencia";
	public static final String KEY_VD = "vida";
	public static final String KEY_FR = "fuerza";
	public static final String KEY_DF = "defensa";
	public static final String KEY_MG = "magia";
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	private static final String ROL_TABLE = "roles";
	static final String DATABASE_CREATE = "create table roles ("+KEY_ID+" integer primary key autoincrement,"
            +KEY_NAME+" text,"
            +KEY_LEVEL+ " integer not null,"
            +KEY_XP+ " integer  not null,"
            +KEY_VD+ " integer not null,"
            +KEY_FR+" integer  not null,"
            +KEY_DF+ " integer not null,"
            +KEY_MG+" integer not null);";
	
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
	
	public boolean updateRol(int rowId, ContentValues values) { 
	      return database.update(ROL_TABLE, values, KEY_ID + "=" + rowId, null) > 0;
	}
	
	public boolean deleteRol(int rowId) {
	      return database.delete(ROL_TABLE, KEY_ID + "=" + rowId, null) > 0;
	}
	
	/*public Cursor fetchRol() {
	      return database.query(ROL_TABLE, new String[] {KEY_NAME, KEY_LEVEL, KEY_XP, KEY_FR, KEY_MG}, null, null, null, null, null);
	}*/
	public Cursor fetchRol(int id) throws SQLException {
		Cursor mCursor = database.rawQuery("Select * from "+ROL_TABLE+ " where "+KEY_ID+ " = " +id, null);
	    if (mCursor != null) {
	    	mCursor.moveToFirst();
	    }
	    return mCursor;
	}
	
	
}