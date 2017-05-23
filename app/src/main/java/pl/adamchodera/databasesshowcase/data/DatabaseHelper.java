/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.adamchodera.databasesshowcase.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 5;

    public static final String DATABASE_NAME = "Tasks.db";

    private static final String TEXT_TYPE = " TEXT";

    private static final String BOOLEAN_TYPE = " INTEGER";

    private static final String COMMA = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TodoContract.TaskEntry.TABLE_NAME + " (" +
                    TodoContract.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    TodoContract.TaskEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA +
                    TodoContract.TaskEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA +
                    TodoContract.TaskEntry.COLUMN_NAME_COMPLETED + BOOLEAN_TYPE +
                    " )";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TodoContract.TaskEntry.TABLE_NAME);
        db.execSQL(SQL_CREATE_ENTRIES);
    }
}
