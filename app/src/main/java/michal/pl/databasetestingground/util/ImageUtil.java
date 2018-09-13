package michal.pl.databasetestingground.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Michał on 12.09.2018.
 */

public class ImageUtil {

    public final String SMALL_PICTURE = "data/obrazek.jpg";
    public final String BIG_PICTURE = "data/obrazek2.png";

    public ImageUtil() {}

    public Bitmap loadImageToBitmap(String path) {
        File file = null;
        Bitmap bitmap = null;
        try {
            file = readFile(path);
            bitmap = BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public byte[] convertBitmapToByteArray(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        return imageBytes;
    }

    public Bitmap convertByteArrayToBitmap(byte[] bytes) {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    private File readFile(String path) throws IOException {
        return new File(Environment.getExternalStorageDirectory(), path);
    }
}
