package com.abdul.bajajdb;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.abdul.bajajdb.db.todo.TodoDao;
import com.abdul.bajajdb.db.todo.TodoNote;

import java.util.List;

public class GetNotesAsyncTask extends AsyncTask<Void,Void, List<TodoNote>> {
    TodoDao todoDao;
    ListView mListView;
    Context mContext;

    public GetNotesAsyncTask(TodoDao dao, ListView listView, Context context){
        todoDao = dao;
        mListView = listView;
        mContext = context;
    }

    @Override
    protected List<TodoNote> doInBackground(Void... voids) {

        return todoDao.getAllNotes();
    }

    @Override
    protected void onPostExecute(List<TodoNote> todoNotes) {
        super.onPostExecute(todoNotes);
        ArrayAdapter<TodoNote> adapter = new ArrayAdapter<TodoNote>(mContext,
                android.R.layout.simple_list_item_1,android.R.id.text1,todoNotes);
        mListView.setAdapter(adapter);
    }
}
