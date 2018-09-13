package michal.pl.databasetestingground.database.impl.Room;

import android.arch.persistence.room.Database;
import michal.pl.databasetestingground.model.Image;

/**
 * Created by Michał on 12.09.2018.
 */

@Database(entities = {Image.class}, version = 1)
public abstract class RoomDatabase extends android.arch.persistence.room.RoomDatabase {
    public abstract RoomImageDao imageDao();
}
