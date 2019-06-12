package com.example.qusionapp.data

class ItemsRepository {

    private val items = listOf(
        Item("Title", "Very long description"),
        Item("Title 2", "Very long description 2"),
        Item("Title 3", "Very long description 3"));

    companion object {
        private var INSTANCE: ItemsRepository = ItemsRepository()

        fun getInstance(): ItemsRepository = INSTANCE
    }

    fun indexOf(item: Item): Int = items.indexOf(item)

    fun fetchItems(): List<Item> = items

    fun fetchItem(index: Int): Item = items[index]
}