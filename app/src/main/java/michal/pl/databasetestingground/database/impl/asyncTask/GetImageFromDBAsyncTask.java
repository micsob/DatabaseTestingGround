package michal.pl.databasetestingground.database.impl.asyncTask;

import android.os.AsyncTask;

import java.util.List;

import michal.pl.databasetestingground.MainActivity;
import michal.pl.databasetestingground.database.ImageDao;
import michal.pl.databasetestingground.model.Image;

/**
 * Created by Michał on 13.09.2018.
 */

public class GetImageFromDBAsyncTask extends AsyncTask<Void, Void, Void> {

    private ImageDao imageDao;
    private MainActivity mainActivity;
    private List<Image> images;

    public GetImageFromDBAsyncTask(ImageDao imageDao, MainActivity mainActivity) {
            this.imageDao = imageDao;
            this.mainActivity = mainActivity;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            images = imageDao.readAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (images.size() > 0) {
            Image image = images.get(0);
            mainActivity.showImage(image);
        }
    }
}
