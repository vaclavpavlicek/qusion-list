package com.example.qusionapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qusionapp.MainActivity

import com.example.qusionapp.R
import com.example.qusionapp.data.Item
import com.example.qusionapp.data.ItemClickListener
import com.example.qusionapp.data.ItemsRepository
import com.example.qusionapp.models.ItemsAdapter


class ItemsFragment : Fragment(), ItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_items, container, false)
        val repository = ItemsRepository.getInstance()
        viewManager = LinearLayoutManager(this.context)
        viewAdapter = ItemsAdapter(repository.fetchItems(), this)

        recyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }

        return view
    }

    override fun onItemClick(item: Item) {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            (activity as MainActivity).goToDetail(item)
        }
    }
}
