package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class ShowActivity extends AppCompatActivity {

    Button btn5stars;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        btn5stars = findViewById(R.id.btn5stars);
        lv = findViewById(R.id.lv);






    }
}