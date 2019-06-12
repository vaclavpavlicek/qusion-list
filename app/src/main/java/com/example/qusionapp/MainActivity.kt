package com.example.qusionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qusionapp.fragments.TodoFragment
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

    fun goToDetail(text: String) {
        val bundle = Bundle()
        bundle.putString("TODO-DETAIL", text)

        val todoFragment = TodoFragment()
        todoFragment.setArguments(bundle)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("todo")
            .replace(
                R.id.fragment_container,
                todoFragment, null
            ).commit()
    }
}
