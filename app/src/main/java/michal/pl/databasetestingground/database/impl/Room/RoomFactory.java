package michal.pl.databasetestingground.database.impl.Room;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by Michał on 12.09.2018.
 */

public class RoomFactory {

    public RoomDatabase create(Context context) {
        return Room.databaseBuilder(context, RoomDatabase.class, "database-name").build();
    }
}
