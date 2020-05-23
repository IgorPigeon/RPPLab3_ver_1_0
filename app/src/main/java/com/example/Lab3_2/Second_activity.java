package com.example.Lab3_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.Lab3_2.FeedReaderContract.FeedReaderDbHelper;
import com.example.Lab3_2.FeedReaderContract.FeedEntry;

import java.util.ArrayList;
import java.util.List;

public class Second_activity extends AppCompatActivity {

    FeedReaderDbHelper dbHelper;
    SQLiteDatabase db;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Log.d("MyTag", "DB opening");
        dbHelper = new FeedReaderDbHelper(getApplicationContext());
        db = dbHelper.getReadableDatabase();

        Log.d("MyTag", "Done");

        String[] projection = {
                BaseColumns._ID,
                FeedEntry.COLUMN_NAME_LASTNAME,
                FeedEntry.COLUMN_NAME_NAME,
                FeedEntry.COLUMN_NAME_FATHNAME,
                FeedEntry.COLUMN_NAME_TIME
        };

         String sortOrder =
                FeedEntry.COLUMN_NAME_LASTNAME + " ASC";

        Log.d("MyTag", "Cursor");

        Cursor cursor = db.query(
                FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                  sortOrder
        );

        List itemIDs = new ArrayList<>();
        List itemDates = new ArrayList<>();
        List itemLastNames = new ArrayList();
        List itemNames = new ArrayList();
        List itemFaths = new ArrayList();
        Log.d("MyTag", "Reading");

        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(BaseColumns._ID));

            String itemLastName = cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_LASTNAME));

            String itemName = cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_NAME));

            String itemFath = cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_FATHNAME));

            String itemDate = cursor.getString(
                    cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TIME));

            itemIDs.add(itemId);
            itemLastNames.add(itemLastName);
            itemNames.add(itemName);
            itemFaths.add(itemFath);
            itemDates.add(itemDate);

        }

        cursor.close();

        mAdapter = new MyAdapter(itemIDs, itemLastNames, itemNames, itemFaths, itemDates);
        recyclerView.setAdapter(mAdapter);
    }

}
