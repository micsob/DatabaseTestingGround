package michal.pl.databasetestingground;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import michal.pl.databasetestingground.database.AppDatabase;
import michal.pl.databasetestingground.database.DatabaseFactory;
import michal.pl.databasetestingground.model.Image;
import michal.pl.databasetestingground.util.ImageUtil;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageUtil imageLoadUtil = new ImageUtil();
        Bitmap bitmap = imageLoadUtil.loadImageToBitmap(imageLoadUtil.SMALL_PICTURE);

        AppDatabase appDatabase = DatabaseFactory.getDatabase(1, getApplicationContext());
        byte[] bytes = imageLoadUtil.convertBitmapToByteArray(bitmap);
        Image image = new Image(bytes);
        appDatabase.save(image);

        appDatabase.readAll(this);
    }

    public void showImage(Image image) {
        Log.e("MainActivity", "showImage");
        ImageUtil imageLoadUtil = new ImageUtil();
        //Bitmap bitmap = imageLoadUtil.loadImageToBitmap(imageLoadUtil.SMALL_PICTURE);
        Bitmap bitmap = imageLoadUtil.convertByteArrayToBitmap(image.getImage());
        imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);
    }
}
