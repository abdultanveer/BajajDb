package com.abdul.bajajdb;

import android.os.AsyncTask;

import com.abdul.bajajdb.db.Word;
import com.abdul.bajajdb.db.WordDao;

public  class insertAsyncTask extends AsyncTask<Word, Void, Void> {

    private WordDao mAsyncTaskDao;

    insertAsyncTask(WordDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Word... params) {
        mAsyncTaskDao.insert(params[0]);
        return null;
    }
}