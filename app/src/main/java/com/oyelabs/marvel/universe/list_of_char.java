package com.oyelabs.marvel.universe;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

public class list_of_char extends AppCompatActivity {


    ListView listView;
    TextView textView;
    String[] listItem;
    ArrayAdapter<String > adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_char);

        listView=(ListView)findViewById(R.id.listView);
        textView=(TextView)findViewById(R.id.name);
        listItem = getResources().getStringArray(R.array.array_list);




         adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listItem);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // TODO Auto-generated method stub
                String value=adapter.getItem(position);

                Intent intent = new Intent(getApplicationContext(), testing_pg_url.class);
                intent.putExtra("characterName", value);
                startActivity(intent);

            }
        });


    }

    public boolean onCreateOptionsMenu(Menu srch) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search, srch);
        MenuItem searchViewItem = srch.findItem(R.id.app_bar_search);
        final SearchView SV = (SearchView) MenuItemCompat.getActionView(searchViewItem);
        SV.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SV.clearFocus();
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(srch);
    }

}
