package com.example.qusionapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.qusionapp.R
import com.example.qusionapp.data.ItemsRepository


class ItemFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item, container, false)

        val itemTitle = view.findViewById(R.id.item_title) as TextView
        val itemDescription = view.findViewById(R.id.item_description) as TextView

        val index = arguments!!.getInt("ITEM-INDEx")

        val repository = ItemsRepository.getInstance()
        val item = repository.fetchItem(index)

        itemTitle.text = item.title
        itemDescription.text = item.description
        return view
    }
}
