package michal.pl.databasetestingground.database.impl.asyncTask;

import android.os.AsyncTask;

import java.time.Duration;
import java.time.LocalTime;

import michal.pl.databasetestingground.database.ImageDao;
import michal.pl.databasetestingground.model.Image;

/**
 * Created by Michał on 13.09.2018.
 */

public class SaveImageToDBAsyncTask extends AsyncTask<Void, Void, Void> {

    private ImageDao imageDao;
    private Image image;
    private LocalTime initialTime;
    private LocalTime finalTime;

    public SaveImageToDBAsyncTask(ImageDao imageDao, Image image) {
        this.imageDao = imageDao;
        this.image = image;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        initialTime = LocalTime.now();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            imageDao.save(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        finalTime = LocalTime.now();
        System.out.println(Duration.between(finalTime,initialTime).getNano());
    }
}
