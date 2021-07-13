package com.abdul.bajajdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var nameET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameET = findViewById(R.id.etDb)
    }

    fun clickHandler(view: View) {
        when(view.id){
            R.id.buttonSet -> {}
            R.id.buttonget -> {}
        }
    }
}