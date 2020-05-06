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
    int memoIndex;
    RecyclerView4Adapter recyclerView4Adapter;
    ArrayList<Memo> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view4);

        arrayList = new ArrayList<Memo>();
        arrayList.add(new Memo("one");
        arrayList.add(new Memo("two"));

        recyclerView4Adapter = new RecyclerView4Adapter(this, arrayList, new OnMemoClickListener() {

            public void onMemoClicked(int index) {

            }
        });


        recyclerView4Adapter = new RecyclerView4Adapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerView4Adapter);


        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_create);
        return true;

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


            public boolean onOptionsItemSelected(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_create) {
                    startMemoActivityForResult(REQUEST_CREATE, null);
                    return true;
                }
                return super.onOptionsItemSelected(item);
            }

            protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
                super.onActivityResult(requestCode, resultCode, intent);
                if (resultCode == RESULT_OK) {
                    Bundle bundle = intent.getExtras();
                    Memo memo = (Memo) bundle.getSerializable("MEMO");
                    if (requestCode == REQUEST_CREATE)
                        arrayList.add(Memo);
                    recyclerView4Adapter.notifyDataSetChanged();
                }
            }

            private void startMemoActivityForResult(int requestCode, Memo memo) {
                android.content.Intent intent = new Intent(this, MemoActivity.class);
                intent.putExtra("MEMO", memo);
                startActivityForResult(intent, requestCode);
            }
        }