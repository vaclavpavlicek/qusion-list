package com.example.qusionapp.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.qusionapp.R
import com.example.qusionapp.TodoClickCallback
import com.example.qusionapp.data.Todo

class TodosAdapter(private val todos: Array<Todo>, private val todoClickCallback: TodoClickCallback) :
    RecyclerView.Adapter<TodosAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val todo = view.findViewById(R.id.todo) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        view.setOnClickListener { v: View? ->
            run {
                val textView = v?.findViewById(R.id.todo) as TextView
                todoClickCallback.onClick(textView.text.toString())
                //Toast.makeText(parent.context, textView.text, Toast.LENGTH_LONG).show()
            }
        }
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.todo.text = todos[position].text + " - " + if (todos[position].done) "yes" else "ne"
    }

    override fun getItemCount() = todos.size
}