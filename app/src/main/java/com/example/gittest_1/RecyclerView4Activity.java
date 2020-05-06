package com.example.gittest_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class RecyclerView4Activity extends AppCompatActivity {
    private static final int REQUEST_CREATE = 0;
    RecyclerView4Adapter recyclerView4Adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view4);

        arrayList = new ArrayList<String>();
        arrayList.add("one");
        arrayList.add("two");

        recyclerView4Adapter = new RecyclerView4Adapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerView4Adapter);

        Button b = (Button)findViewById(R.id.buttonsave);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                EditText e = (EditText) findViewById(R.id.editText);
                String s = e.getText().toString();
                e.setText("");
                arrayList.add(s);
                recyclerView4Adapter.notifyDataSetChanged();
            }
            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu, menu);
                MenuItem menuItem = menu.findItem(R.id.action_create);
                menuItem.setVisible(recyclerView4Adapter.checkedCount > 0);
                return true;
            }

            @Override public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_create) {
                    startMemoActivityForResult(REQUEST_CREATE, null);
                    return true;

                });
                private void startMemoActivityForResult(int requestCode, Memo memo) {
                    Intent intent = new Intent(this, MemoActivity.class);
                    intent.putExtra("MEMO", memo);
                    startActivityForResult(intent, requestCode);
                }
            }
    }

}