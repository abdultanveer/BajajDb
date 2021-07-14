package com.abdul.bajajdb;

import android.os.AsyncTask;

import com.abdul.bajajdb.db.todo.TodoDao;
import com.abdul.bajajdb.db.todo.TodoNote;

public  class insertTodonoteAsyncTask extends AsyncTask<TodoNote, Void, Void> {

    private TodoDao mAsyncTaskDao;

    insertTodonoteAsyncTask(TodoDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final TodoNote... params) {
        mAsyncTaskDao.insertNote(params[0]);
        return null;
    }
}