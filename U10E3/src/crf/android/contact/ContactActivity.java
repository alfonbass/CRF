package crf.android.contact;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.widget.SimpleCursorAdapter;

public class ContactActivity extends ListActivity {	
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	
	String[] projection=new String[] {
			Phone.DISPLAY_NAME,
			Phone.NUMBER};
	
	String filtro=Phone.DISPLAY_NAME+"LIKE ?"; //Filtro
	
	Cursor cursor=getContentResolver().query(
			ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
			projection, 
			filtro, null, 
			Phone.DISPLAY_NAME+"ASC");
	
	startManagingCursor(cursor);
	String[] from=new String[]{ Phone.DISPLAY_NAME, Phone.NUMBER};
	int[] to=new int[]{ R.id.name, R.id.telefono};
	SimpleCursorAdapter adapter=new SimpleCursorAdapter(this, R.layout.main, cursor, from, to);
	this.setListAdapter(adapter);
	}
}