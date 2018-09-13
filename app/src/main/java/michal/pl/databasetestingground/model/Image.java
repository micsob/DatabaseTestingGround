package michal.pl.databasetestingground.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Blob;

import lombok.Data;

/**
 * Created by Michał on 12.09.2018.
 */

@Entity
public class Image {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] image;

    public Image() {}

    public Image(byte[] image) {
        this.image = image;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
