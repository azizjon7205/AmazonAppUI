package com.example.amazonappui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonappui.adapter.BooksAdapter
import com.example.amazonappui.adapter.DepartmentAdapter
import com.example.amazonappui.adapter.EssentialAdapter
import com.example.amazonappui.model.Books
import com.example.amazonappui.model.Department
import com.example.amazonappui.model.Essential

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewBooks: RecyclerView
    private lateinit var recyclerViewDepartments: RecyclerView
    private lateinit var llFashion: LinearLayout
    private lateinit var llPopular: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews(){
        llFashion = findViewById(R.id.ll_fashion)
        llPopular = findViewById(R.id.ll_popular)
        recyclerView = findViewById(R.id.rv_essential)
        recyclerViewBooks = findViewById(R.id.rv_books)
        recyclerViewDepartments = findViewById(R.id.rv_departments)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewBooks.layoutManager = GridLayoutManager(this, 1)
        recyclerViewDepartments.layoutManager = GridLayoutManager(this, 2)

        refreshAdapterEssentials(getEssentials())
        refreshAdapterBooks(getBooks())
        refreshAdapterDepartments(getDepartments()  )

        setLinearHeight(llFashion)
        setLinearHeight(llPopular)
    }

    private fun refreshAdapterEssentials(items: ArrayList<Essential>){
        val adapter = EssentialAdapter(this, items)
        recyclerView.adapter = adapter
    }

    private fun refreshAdapterBooks(items: ArrayList<Books>){
        val adapter = BooksAdapter(this, items)
        recyclerViewBooks.adapter = adapter
    }

    private fun refreshAdapterDepartments(items: ArrayList<Department>){
        val adapter = DepartmentAdapter(this, items)
        recyclerViewDepartments.adapter = adapter
    }


    private fun setLinearHeight(layout: LinearLayout){
        // get screen width programmatically
        val  displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val widthPixels = displayMetrics.widthPixels

        // set layout width programmatically
        val params: ViewGroup.LayoutParams = layout.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }

    private fun getEssentials(): ArrayList<Essential>{
        val items = ArrayList<Essential>()

        items.add(Essential("Oculus", R.drawable.im_product_31))
        items.add(Essential("Gamer", R.drawable.im_product_32))
        items.add(Essential("Mobile", R.drawable.im_product_34))

        return items
    }

    private fun getBooks(): ArrayList<Books>{
        val items = ArrayList<Books>()

        items.add(Books(R.drawable.im_book_1, "The Very Hungry Caterpillar", "5.06", "5.06"))
        items.add(Books(R.drawable.im_book_2, "If Animals Kissed Good Night", "3.55", "7.99"))
        items.add(Books(R.drawable.im_book_3, "Chicka Chicka Boom Boom (Board Book)", "4.59", "7.99"))

        return items
    }

    private fun getDepartments(): ArrayList<Department>{
        val items = ArrayList<Department>()

        items.add(Department(R.drawable.im_beauty_1, "Beauty"))
        items.add(Department(R.drawable.im_kitchen, "Home and Kitchen"))
        items.add(Department(R.drawable.im_sports_outdoors, "Sports and Outdoors"))
        items.add(Department(R.drawable.im_electronics, "Electronics"))
        items.add(Department(R.drawable.im_outdoor_clothing, "Outdoor clothing"))
        items.add(Department(R.drawable.im_pet_supplies, "Pet Supplies"))

        return items
    }
}