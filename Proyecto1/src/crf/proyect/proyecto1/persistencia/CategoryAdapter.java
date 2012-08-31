package crf.proyect.proyecto1.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class CategoryAdapter {
	public static final String KEY_ID = "id";
	public static final String KEY_NAME ="nombre";
	private DatabaseHelper databaseHelper;
	private SQLiteDatabase database;
	
	private static final String CATEGORY_TABLE = "categoria";
	static final String DATABASE_CREATE = "create table category (id text primary key,"
			+"KEY_ID not null,"
			+"KEY_NAME not null,);";
	
	private final Context context;
	
	public CategoryAdapter(Context cntxt) {
	      this.context = cntxt;
	      databaseHelper = new DatabaseHelper(context);
	      database = databaseHelper.getWritableDatabase();
	}
	
	public void close() {
		databaseHelper.close();
	}
	
	public long createCategory(ContentValues initialValues) {
	      return database.insert(CATEGORY_TABLE, null, initialValues);
	}
	
	public boolean deleteCategory(long rowId) {
	      return database.delete(CATEGORY_TABLE, KEY_ID + "=" + rowId, null) > 0;
	}
	public Cursor fetchCategory(int id) throws SQLException {
		Cursor mCursor = database.rawQuery("Select * from "+CATEGORY_TABLE+ " where "+KEY_ID+ " = " +id, null);
	    if (mCursor != null) {
	    	mCursor.moveToFirst();
	    }
	    return mCursor;
	}
	
	public boolean updateCount(long rowId, ContentValues values) {
	      return database.update(CATEGORY_TABLE, values, KEY_ID + "=" + rowId, null) > 0;//posible fallo
	}

}
