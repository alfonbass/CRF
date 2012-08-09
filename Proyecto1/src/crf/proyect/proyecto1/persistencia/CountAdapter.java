package crf.proyect.proyecto1.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CountAdapter {
	public static final String KEY_NAME ="nombre";
	public static final String KEY_MONEY = "dinero";
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	private static final String COUNT_TABLE = "conta";
	static final String DATABASE_CREATE = "create table count (name text primary key,"
			+"KEY_MONEY not null,"
			+"KEY_MONEY not null,);";
	
	private final Context context;
	
	public CountAdapter(Context cntxt) {
	      this.context = cntxt;
	      databaseHelper = new DatabaseHelper(context);
	      database = databaseHelper.getWritableDatabase();
	}
	
	public void close() {
		databaseHelper.close();
	}
	
	public long createCount(ContentValues initialValues) {
	      return database.insert(COUNT_TABLE, null, initialValues);
	}
	
	public boolean deleteCount(long rowName) {
	      return database.delete(COUNT_TABLE, KEY_NAME + "=" + rowName, null) > 0;
	}
	public Cursor fetchCount(String rowName) throws SQLException {
		Cursor mCursor = database.rawQuery("Select * from "+COUNT_TABLE+ " where "+KEY_NAME+ " = " +rowName, null);
	    if (mCursor != null) {
	    	mCursor.moveToFirst();
	    }
	    return mCursor;
	}
	
	public boolean updateCount(long rowName, ContentValues values) {
	      return database.update(COUNT_TABLE, values, KEY_NAME + "=" + rowName, null) > 0;//posible fallo
	}

}
