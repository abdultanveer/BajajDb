package com.abdul.bajajdb.db.todo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TodoNote {
    @PrimaryKey(autoGenerate = true)
    int id;
    String title;
    String description;

    public TodoNote(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoNote{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
