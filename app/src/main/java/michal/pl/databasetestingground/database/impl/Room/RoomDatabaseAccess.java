package michal.pl.databasetestingground.database.impl.Room;

import michal.pl.databasetestingground.database.AppDatabase;
import michal.pl.databasetestingground.database.ImageDao;

/**
 * Created by Michał on 12.09.2018.
 */

public class RoomDatabaseAccess extends AppDatabase {

    private RoomDatabase roomDatabase;

    public RoomDatabaseAccess(RoomDatabase roomDatabase) {
        super();
        this.roomDatabase = roomDatabase;
    }

    @Override
    public ImageDao getImageDao() {
        ImageDao abstractDao = roomDatabase.imageDao();
        return abstractDao;
    }
}
