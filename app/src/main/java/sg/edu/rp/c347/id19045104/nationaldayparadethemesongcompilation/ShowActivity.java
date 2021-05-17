package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        al.clear();
        al.addAll(dbh.getAllNotes(""));
        dbh.close();

        String txt = "";
        for (int i = 0; i< al.size(); i++){
            Note tmp = al.get(i);
            txt += "ID:" + tmp.getId() + ", " + tmp.getNoteContent() + "\n";
        }
        tvDBContent.setText(txt);
        aa.notifyDataSetChanged();



    }
}