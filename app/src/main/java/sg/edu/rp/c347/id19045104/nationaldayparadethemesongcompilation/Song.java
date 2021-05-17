package sg.edu.rp.c347.id19045104.nationaldayparadethemesongcompilation;

import java.io.Serializable;

public class Song implements Serializable {
    private int _id;
    private String title;
    private String singers;
    private int years;
    private int stars;

    public Song(int _id, String title, String singers, int years, int stars) {
        this._id = _id;
        this.title = title;
        this.singers = singers;
        this.years = years;
        this.stars = stars;
    }

    public int get_id() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getSingers() {
        return singers;
    }

    public int getYears() {
        return years;
    }

    public int getStars() {
        return stars;
    }


}
