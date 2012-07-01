package crf.android.contact;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ContactActivity extends ListActivity {	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);
	
		String[] projection=new String[] {Phone._ID, Phone.DISPLAY_NAME, Phone.NUMBER};
	
		//String filtro=Phone.DISPLAY_NAME+" LIKE ?"; Filtro posible
	
		Cursor cursor=getContentResolver().query(
			ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
			projection, 
			null, null, 
			Phone.DISPLAY_NAME+" ASC");
	
		startManagingCursor(cursor);
		String[] from=new String[]{ Phone.DISPLAY_NAME, Phone.NUMBER};
		int[] to=new int[]{ R.id.name, R.id.telefono};
		SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, R.layout.main, cursor, from, to);	
		this.setListAdapter(adapter);	
	}
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Cursor c = ((Cursor) l.getAdapter().getItem(position));
		Toast.makeText(getBaseContext(), c.getString(c.getColumnIndex(Phone.DISPLAY_NAME)), Toast.LENGTH_LONG).show();
	}
}