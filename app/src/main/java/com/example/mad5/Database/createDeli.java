package com.example.mad5.Database;
//createDeli


import android.provider.BaseColumns;

public final class createDeli {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private createDeli() {}

    /* Inner class that defines the table contents */
    public static class delivers implements BaseColumns {
        public static final String TABLE_NAME = "deliveryInfo";
        public static final String COLUMN_1 = "name";
        public static final String COLUMN_2 = "phone";
        public static final String COLUMN_3 = "address";
        public static final String COLUMN_4 = "location";
        public static final String COLUMN_5 = "type";
    }
}
