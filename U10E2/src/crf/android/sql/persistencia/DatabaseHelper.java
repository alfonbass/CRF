package crf.android.sql.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final int DATABASE_VERSION = 2;
	private static final String DATABASE_NAME = "game_database";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(RolAdapter.DATABASE_CREATE);
	}
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("ALTER TABLE " +RolAdapter.ROL_TABLE+ " ADD defensa INTEGER NOT NULL DEFAULT 1");
        db.execSQL("ALTER TABLE " +RolAdapter.ROL_TABLE+ " ADD vida INTEGER NOT NULL DEFAULT 100");
	}
}
