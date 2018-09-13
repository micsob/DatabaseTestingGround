package michal.pl.databasetestingground.database;

import java.util.List;

import michal.pl.databasetestingground.MainActivity;
import michal.pl.databasetestingground.database.impl.asyncTask.GetImageFromDBAsyncTask;
import michal.pl.databasetestingground.database.impl.asyncTask.SaveImageToDBAsyncTask;
import michal.pl.databasetestingground.model.Image;

/**
 * Created by Michał on 12.09.2018.
 */

public abstract class AppDatabase {
    public abstract ImageDao getImageDao();

    public void save(Image image) {
        ImageDao imageDao = getImageDao();
        new SaveImageToDBAsyncTask(imageDao, image).execute();
    }

    public void readAll(MainActivity mainActivity) {
        ImageDao imageDao = getImageDao();
        new GetImageFromDBAsyncTask(imageDao, mainActivity).execute();
    }
}
