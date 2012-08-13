package crf.proyect.proyecto1.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CountManager {
	CountAdapter countAdapter;

    public CountManager(Context context){
      countAdapter = new CountAdapter(context);
    }

    public long createCount(Count count){
      ContentValues countContentValues = convertCountInContentValues(count);
      return countAdapter.createCount(countContentValues);
    }

    public Count getCountByName(String name){
      Cursor countCursor = countAdapter.fetchCount(name);
      return convertCursorInCount(countCursor);
    }

    private ContentValues convertCountInContentValues(Count count) {
      ContentValues contentValues = new ContentValues();
      contentValues.put(CountAdapter.KEY_ID, count.getId());
      contentValues.put(CountAdapter.KEY_NAME, count.getName());
      contentValues.put(CountAdapter.KEY_MONEY, count.getMoney());
      return contentValues;
    }

    private Count convertCursorInCount(Cursor cursor) {
      Count count = new Count();
      count.setId(cursor.getInt(cursor.getColumnIndex(CountAdapter.KEY_ID)));
      count.setName(cursor.getString(cursor.getColumnIndex(CountAdapter.KEY_NAME)));
      count.setMoney(cursor.getInt(cursor.getColumnIndex(CountAdapter.KEY_MONEY)));
      cursor.close();
      return count;
    }
}