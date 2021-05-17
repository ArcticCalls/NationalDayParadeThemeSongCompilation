package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity {

    Button btn5stars;
    ListView lv;
    ArrayList<Song> al;
    ArrayAdapter<Song> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        btn5stars = findViewById(R.id.btn5stars);
        lv = findViewById(R.id.lv);

        al = new ArrayList<Song>();
        DBHelper dbh = new DBHelper(ShowActivity.this);
        al.addAll(dbh.getAllSong());
        dbh.close();
        aa = new SongListArrayAdapter(ShowActivity.this, R.layout.row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song target = al.get(position);
                Intent i = new Intent(ShowActivity.this, ModifyActivity.class);
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });
//        btn5stars.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBHelper dbh = new DBHelper(ShowActivity.this);
//                al.clear();
//                al.addAll(dbh.getAllSong());
//                dbh.close();
//
//                String txt = "";
//                for (int i = 0; i< al.size(); i++){
//                    Song tmp = al.get(i);
//                    txt += "ID:" + tmp.get_id() + ", " + tmp.getTitle() + "\n";
//                }
//                tvDBContent.setText(txt);
//                aa.notifyDataSetChanged();
//            }
//        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9){
//            btnRetrieve.performClick();
        }
    }
}