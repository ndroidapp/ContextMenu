package com.example.android.contextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    private static int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        arrayList=new ArrayList<String>();
        arrayList.add("Delhi");
        arrayList.add("Agra");
        arrayList.add("Noida");
        arrayList.add("Kolkata");
        arrayList.add("Assam");
        arrayList.add("Goa");
        arrayList.add("Jaipur");
        arrayList.add("Pune");
        arrayList.add("Kanpur");
        arrayList.add("Malda Town");
        arrayList.add("Varanasi");
        arrayList.add("Lucknow");
        arrayList.add("Patna");
        arrayList.add("Salt Lake");
        arrayList.add("Jalpaiguri");
        arrayList.add("Panipat");
        arrayList.add("Krukshetra");
        arrayList.add("Mumbai");
        arrayList.add("Chennai");

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                MainActivity.position=position;
                return false;
            }
        });
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Options");
        menu.add(0,v.getId(),0,"Save");
        menu.add(0,v.getId(),0,"Share");
        menu.add(0,v.getId(),0,"Move");
        menu.add(0,v.getId(),0,"Delete");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle()=="Save"){
            Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        } else if (item.getTitle()=="Share"){
            Toast.makeText(MainActivity.this, "Shared", Toast.LENGTH_SHORT).show();
        }else if (item.getTitle()=="Move"){
            Toast.makeText(MainActivity.this, "Moved", Toast.LENGTH_SHORT).show();
        }else if (item.getTitle()=="Delete"){
            Toast.makeText(MainActivity.this, arrayList.get(MainActivity.position)+" is deleted", Toast.LENGTH_SHORT).show();
            arrayList.remove(MainActivity.position);
            adapter.notifyDataSetChanged();

        }
        return super.onContextItemSelected(item);
    }
}
