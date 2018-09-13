package michal.pl.databasetestingground.database;

import android.graphics.Bitmap;

import java.util.List;

import michal.pl.databasetestingground.model.Image;

/**
 * Created by Michał on 12.09.2018.
 */

public interface ImageDao {
    public void save(Image image);
    public List<Image> readAll();
}
