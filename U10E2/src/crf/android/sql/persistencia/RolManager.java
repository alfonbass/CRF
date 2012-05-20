package crf.android.sql.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class RolManager {
	RolAdapter rolAdapter;

    public RolManager(Context context){
      rolAdapter = new RolAdapter(context);
    }

    public long createRol(Rol rol){
      ContentValues rolContentValues = convertRolInContentValues(rol);
      return rolAdapter.createRol(rolContentValues);
    }

    public Rol getRolById(int id){
      Cursor rolCursor = rolAdapter.fetchRol(id);
      return convertCursorInRol(rolCursor);
    }

    private ContentValues convertRolInContentValues(Rol rol) {
      ContentValues contentValues = new ContentValues();
      contentValues.put(RolAdapter.KEY_ID, rol.getId());
      contentValues.put(RolAdapter.KEY_NAME, rol.getName());
      contentValues.put(RolAdapter.KEY_LEVEL, rol.getLevel());
      contentValues.put(RolAdapter.KEY_XP, rol.getXp());
      contentValues.put(RolAdapter.KEY_FR, rol.getFr());
      contentValues.put(RolAdapter.KEY_MG, rol.getMg());
      return contentValues;
    }

    private Rol convertCursorInRol(Cursor cursor) {
      Rol rol = new Rol();
      rol.setId(cursor.getInt(cursor.getColumnIndex(RolAdapter.KEY_ID)));
      rol.setName(cursor.getString(cursor.getColumnIndex(RolAdapter.KEY_NAME)));
      rol.setLevel(cursor.getInt(cursor.getColumnIndex(RolAdapter.KEY_LEVEL)));
      rol.setXp(cursor.getInt(cursor.getColumnIndex(RolAdapter.KEY_XP)));
      rol.setFr(cursor.getInt(cursor.getColumnIndex(RolAdapter.KEY_FR)));
      rol.setMg(cursor.getInt(cursor.getColumnIndex(RolAdapter.KEY_MG)));
      cursor.close();
      return rol;
    }
}