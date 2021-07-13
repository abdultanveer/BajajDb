package com.abdul.bajajdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.abdul.bajajdb.db.Word
import com.abdul.bajajdb.db.WordDao
import com.abdul.bajajdb.db.WordRoomDatabase

class MainActivity : AppCompatActivity() {
    lateinit var database: WordRoomDatabase
    lateinit var wordDao: WordDao
    lateinit var nameET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameET = findViewById(R.id.etDb)
        database = WordRoomDatabase.getDatabase(this)
        wordDao = database.wordDao()
    }

    fun clickHandler(view: View) {
        when(view.id){
            R.id.buttonSet -> {
                var name = nameET.text.toString()
                var word = Word(name)
                //wordDao.insert(word)
                insertData(word)
                Toast.makeText(this,"set successfully",Toast.LENGTH_SHORT).show()
                nameET.setText("")
            }
            R.id.buttonget -> {}
        }
    }

    fun insertData( word: Word){
        insertAsyncTask(wordDao).execute(word)
    }
}