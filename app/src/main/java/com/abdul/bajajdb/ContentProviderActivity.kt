package com.abdul.bajajdb

import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CallLog
import android.widget.CursorAdapter
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class ContentProviderActivity : AppCompatActivity() {
    lateinit var listview: ListView
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        listview = findViewById(R.id.cp_listview)
        val allMessages: Uri = CallLog.Calls.CONTENT_URI
            //Uri.parse("content://sms/inbox")
if(isPermissionGranted()) {
    val cursor: Cursor? = this.contentResolver.query(
        allMessages,
        null, //null = selecting all the columns
        null, //null = selecting all the rows
        null, null
    )


    var fromColNames = Array<String>(1) { CallLog.Calls.NUMBER }
    //"body"}
    var toTextviewIds = IntArray(1) { android.R.id.text1 }

    var cursorAdapter = SimpleCursorAdapter(
        this,
        android.R.layout.simple_list_item_1,
        cursor,
        fromColNames,
        toTextviewIds
    )
    listview.adapter = cursorAdapter

}
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun isPermissionGranted(): Boolean {
        if(checkSelfPermission(android.Manifest.permission.READ_CALL_LOG )
                    == PackageManager.PERMISSION_GRANTED){
            return true
        }
        else{
            ActivityCompat.requestPermissions(this,
                Array(1){android.Manifest.permission.READ_CALL_LOG},
                123) //start settings activity
        }
        return false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}