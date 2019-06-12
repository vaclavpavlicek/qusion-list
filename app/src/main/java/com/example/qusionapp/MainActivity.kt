package com.example.qusionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qusionapp.fragments.TodosFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, TodosFragment(), "TODOS fragment").commit()
        }
    }
}
