import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Dale on 4/10/2018.
 */

public class HelperDB extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "person.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_PERSON = "CREATE TABLE " + Person_info.PersonEntry.TABLE_NAME + " (" +
            Person_info.PersonEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
            Person_info.PersonEntry.COLUMN_NAME_EVENT + TEXT_TYPE + COMMA_SEP +
            Person_info.PersonEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
            Person_info.PersonEntry.COLUMN_DATE + TEXT_TYPE + COMMA_SEP +
            Person_info.PersonEntry.TIME + TEXT_TYPE +
            Person_info.PersonEntry.COLUMN_EMAIL + TEXT_TYPE +  " )";


    private static final String SQL_DELETE =
            "DROP TABLE IF EXISTS" + Person_info.PersonEntry.TABLE_NAME;

    public HelperDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PERSON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE);
        onCreate(db);
    }






}
