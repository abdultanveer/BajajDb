package com.abdul.bajajdb

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ContentProviderActivity : AppCompatActivity() {
    lateinit var listview: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        listview = findViewById(R.id.cp_listview)
        val allMessages: Uri = CallLog.Calls.CONTENT_URI
            //Uri.parse("content://sms/inbox")

        val cursor: Cursor? = this.contentResolver.query(
            allMessages,
            null, //null = selecting all the columns
            null, //null = selecting all the rows
            null, null
        )

        var fromColNames = Array<String>(1){CallLog.Calls.NUMBER}
            //"body"}
        var toTextviewIds = IntArray(1){android.R.id.text1}

        var cursorAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_1,
            cursor,
            fromColNames,
            toTextviewIds)
        listview.adapter = cursorAdapter


    }
}