package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;


public class ModifyActivity extends AppCompatActivity {

    EditText etSID, etSTitle, etSinger, etYear;
    RadioButton btnRadio1, btnRadio2, btnRadio3, btnRadio4, btnRadio5;
    Button btnUpdate, btnDelete, btnCancel;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        //initialize the variables with UI here
        etSID = findViewById(R.id.etSID);
        etSTitle = findViewById(R.id.etSTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);

        btnRadio1 = findViewById(R.id.btnRadio1);
        btnRadio2 = findViewById(R.id.btnRadio2);
        btnRadio3 = findViewById(R.id.btnRadio3);
        btnRadio4 = findViewById(R.id.btnRadio4);
        btnRadio5 = findViewById(R.id.btnRadio5);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        etSID.setText(String.valueOf(data.get_id()));
        etSTitle.setText(data.getTitle());
        etSinger.setText(data.getSingers());
        etYear.setText(String.valueOf(data.getYear()));

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                data.set_id(Integer.parseInt(etSID.getText().toString()));
                data.setTitle(etSTitle.getText().toString());
                data.setSingers(etSinger.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                if (data.getStars() == 1){
                    btnRadio1.setChecked(true);
                }
                else if (data.getStars() == 2){
                    btnRadio2.setChecked(true);
                }
                else if (data.getStars() == 3){
                    btnRadio3.setChecked(true);
                }
                else if (data.getStars() == 4){
                    btnRadio4.setChecked(true);
                }
                else if (data.getStars() == 5){
                    btnRadio5.setChecked(true);
                }
                data.setYear(Integer.parseInt(etYear.getText().toString()));
                dbh.updateNote(data);
                dbh.close();
                setResult(RESULT_OK, i);
                finish();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ModifyActivity.this);
                dbh.deleteNote(data.get_id());
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
