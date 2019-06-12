package com.example.qusionapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.qusionapp.data.Item
import com.example.qusionapp.data.ItemsRepository
import com.example.qusionapp.fragments.ItemFragment
import com.example.qusionapp.fragments.ItemsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ItemsFragment(), "TODOS fragment").commit()
        }
    }

    fun goToDetail(item: Item) {
        val bundle = Bundle()
        val itemsRepository = ItemsRepository.getInstance()

        bundle.putInt("ITEM-INDEx", itemsRepository.indexOf(item))

        val todoFragment = ItemFragment()
        todoFragment.setArguments(bundle)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("item")
            .replace(
                R.id.fragment_container,
                todoFragment, null
            ).commit()
    }
}
