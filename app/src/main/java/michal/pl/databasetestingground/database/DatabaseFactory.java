package michal.pl.databasetestingground.database;

import android.content.Context;

import michal.pl.databasetestingground.database.impl.Room.RoomDatabase;
import michal.pl.databasetestingground.database.impl.Room.RoomDatabaseAccess;
import michal.pl.databasetestingground.database.impl.Room.RoomFactory;

/**
 * Created by Michał on 12.09.2018.
 */

public class DatabaseFactory {

    public static final int ROOM_DATABASE = 1;

    public static AppDatabase getDatabase(int db, Context context) {
        AppDatabase appDatabase = null;
        switch (db) {
            case ROOM_DATABASE:
                RoomFactory factory = new RoomFactory();
                RoomDatabase roomDatabase = factory.create(context);
                RoomDatabaseAccess roomDatabaseAccess = new RoomDatabaseAccess(roomDatabase);
                appDatabase = roomDatabaseAccess;
                break;
        }
        return appDatabase;
    }
}
