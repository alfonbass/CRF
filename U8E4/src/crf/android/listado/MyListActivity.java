package crf.android.listado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

public class MyListActivity extends ListActivity{
	
	String[] from = new String[] {"display_name", "data1"};
	int[] to = new int[] { R.id.name_empty, R.id.number_empty};

	List<HashMap<String,String>> dataMap;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        List<HashMap<String, String>> dataMap = new ArrayList<HashMap<String, String>>();
        
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("display_name", "Jose Cortés");
        map.put("data1","555444333");
        dataMap.add(map);

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("display_name", "Roberto Brenlla");
        map1.put("data1","3322244411");
        dataMap.add(map1);

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("display_name", "Alberto Gimenez");
        map2.put("data1","9998887733");
        dataMap.add(map2);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, dataMap, R.layout.row, from, to);
        this.setListAdapter(simpleAdapter);
    }
}