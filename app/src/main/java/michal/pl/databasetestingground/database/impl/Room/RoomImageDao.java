package michal.pl.databasetestingground.database.impl.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import michal.pl.databasetestingground.database.ImageDao;
import michal.pl.databasetestingground.model.Image;

/**
 * Created by Michał on 12.09.2018.
 */

@Dao
public interface RoomImageDao extends ImageDao {

    @Override
    @Insert
    void save(Image image);

    @Override
    @Query("SELECT * FROM image")
    List<Image> readAll();
}
