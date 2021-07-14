package com.abdul.bajajdb.db.todo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.abdul.bajajdb.db.word.WordRoomDatabase;


@Database(entities = {TodoNote.class}, version = 1)
public abstract class TodoRoomDb extends RoomDatabase {
    public  abstract TodoDao todoDao();

    private static TodoRoomDb INSTANCE;

    public static TodoRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TodoRoomDb.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TodoRoomDb.class, "todo_database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
