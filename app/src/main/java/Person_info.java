

import android.provider.BaseColumns;

public final class Person_info {

    public Person_info() {
    }

    public static abstract class PersonEntry implements BaseColumns {
        public static final String TABLE_NAME = "event database";
        public static final String COLUMN_NAME_EVENT = "Event";
        public static final String COLUMN_NAME_DESCRIPTION = "eventDescription";
        public static final String COLUMN_DATE = "Date";
        public static final String COLUMN_EMAIL = "email";
        public static final String TIME = "time";
    }
}