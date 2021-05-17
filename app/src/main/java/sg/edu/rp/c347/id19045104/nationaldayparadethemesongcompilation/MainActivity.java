package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //this is a test line only
    EditText etSong, etSinger, etYear;
    RadioGroup rgStar;
    Button btnInsert, btnShow;
    ArrayList<Song> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSong = findViewById(R.id.etSong);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);

        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song = etSong.getText().toString();
                String singer = etSinger.getText().toString();
                String year = etYear.getText().toString();
                DBHelper dbh = new DBHelper(MainActivity.this);


            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);
                al.clear();
                al.addAll(dbh.getAllSong());
                Intent i = new Intent(MainActivity.this, ShowActivity.class);
            }
        });

    }



}