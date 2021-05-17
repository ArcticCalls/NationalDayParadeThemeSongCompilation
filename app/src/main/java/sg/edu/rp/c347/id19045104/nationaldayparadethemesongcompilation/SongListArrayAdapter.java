package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListArrayAdapter extends ArrayAdapter<Song> {

    Context context;
    ArrayList<Song> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5;
    TextView textViewYear, textViewTitle, textViewSinger;


    public SongListArrayAdapter(Context context, int resource, ArrayList<Song> notes) {
        super(context, resource, notes);
        this.context = context;
        this.songs = songs;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        textViewYear = rowView.findViewById(R.id.textViewYear);
        textViewTitle = rowView.findViewById(R.id.textViewTitle);
        textViewSinger = rowView.findViewById(R.id.textViewSinger);
        iv1 = rowView.findViewById(R.id.imageView1star);
        iv2 = rowView.findViewById(R.id.imageView2star);
        iv3 = rowView.findViewById(R.id.imageView3star);
        iv4 = rowView.findViewById(R.id.imageView4star);
        iv5 = rowView.findViewById(R.id.imageView5star);

        Song currentSong = songs.get(position);
        textViewYear.setText(currentSong.getYear());
        textViewTitle.setText(currentSong.getTitle());
        textViewSinger.setText(currentSong.getSingers());

        int stars = currentSong.getStars();
        if (stars >= 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if(stars == 4) {
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);

        } else if(stars == 3) {
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else if(stars == 2) {
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}

