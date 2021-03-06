package ar.com.tuxis.itmovie.database.Review;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.util.Log;

import ar.com.tuxis.itmovie.database.Review.ReviewDao;
import ar.com.tuxis.itmovie.database.Review.ReviewEntry;

@Database(entities = {ReviewEntry.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String LOG_TAG = ar.com.tuxis.itmovie.database.Review.AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "reviewlist";
    private static ar.com.tuxis.itmovie.database.Review.AppDatabase sInstance;

    public static ar.com.tuxis.itmovie.database.Review.AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        ar.com.tuxis.itmovie.database.Review.AppDatabase.class, ar.com.tuxis.itmovie.database.Review.AppDatabase.DATABASE_NAME)
                        .build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }

    public abstract ReviewDao reviewDao();
}
