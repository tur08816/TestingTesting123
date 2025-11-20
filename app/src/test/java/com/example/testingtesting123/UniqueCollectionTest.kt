package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    lateinit var Item1: Item
    lateinit var Item2: Item
    lateinit var string1: String

    @Before
    fun setUp() {
        collection = UniqueCollection()
        string1 = "Item1"
        Item1 = Item(string1)
        Item2 = Item("two")
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        collection.addItem(Item1)
        val Item = collection.get(0)
        assert(Item.name == Item1.name){"Item was not added correctly"}
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        collection.addItem(Item1)
        collection.addItem(Item1)
        collection.addItem(Item(string1))
        collection.addItem(Item2)
        val numberOfItemsInCollection = collection.size()
        assert(numberOfItemsInCollection == 2){"Method did not check for completeness properly"}
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}