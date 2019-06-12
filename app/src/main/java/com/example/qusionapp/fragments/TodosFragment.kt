package com.example.qusionapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qusionapp.MainActivity

import com.example.qusionapp.R
import com.example.qusionapp.TodoClickCallback
import com.example.qusionapp.data.Todo
import com.example.qusionapp.models.TodosAdapter


class TodosFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val todoClickCallback = object : TodoClickCallback {
        override fun onClick(text: String) {

            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
                (activity as MainActivity).goToDetail(text)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_todos, container, false)

        viewManager = LinearLayoutManager(this.context)
        viewAdapter = TodosAdapter(arrayOf(Todo(false, "text"), Todo(true, "text")), todoClickCallback)

        recyclerView = view.findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)

            layoutManager = viewManager

            adapter = viewAdapter

        }

        return view
    }
}
