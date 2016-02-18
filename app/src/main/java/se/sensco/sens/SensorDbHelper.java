package se.sensco.sens;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class SensorDbHelper extends SQLiteOpenHelper {

    /* Inner class that defines the table contents */
    public static abstract class Sensors implements BaseColumns {
        public static final String TABLE_NAME = "sensors";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_TEMP = "temp";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_SENSORS =
            "CREATE TABLE " + Sensors.TABLE_NAME + " (" +
                    Sensors._ID + " INTEGER PRIMARY KEY, " +
                    Sensors.COLUMN_NAME_NAME + TEXT_TYPE + COMMA_SEP +
                    Sensors.COLUMN_NAME_TEMP + INTEGER_TYPE + COMMA_SEP +
                    ")";

    public static final String SQL_DELETE_SENSORS =
            "DROP TABLE IF EXISTS " + Sensors.TABLE_NAME;


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sensors.db";

    public SensorDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_SENSORS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_SENSORS);
        onCreate(db);
    }
}
