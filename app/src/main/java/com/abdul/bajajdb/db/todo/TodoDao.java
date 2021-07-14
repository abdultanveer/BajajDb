package com.abdul.bajajdb.db.todo;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * db accesss object -- CRUD
 */
@Dao
public interface TodoDao {
    @Insert
    public void insertNote(TodoNote note); // insert into table_name (title,description) values {"title", "description"}


    @Query("select * from TodoNote")
    public List<TodoNote> getAllNotes();

    /*public void readNote();
    public void updateNote();
    public void deleteNote();*/

}
