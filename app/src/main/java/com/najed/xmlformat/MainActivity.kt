package com.najed.xmlformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var studentsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recycler view
        studentsRecyclerView = findViewById(R.id.students_rv)
        studentsRecyclerView.adapter = Adapter(getStudents())
        studentsRecyclerView.layoutManager = GridLayoutManager(this, 3)
    }

    private fun getStudents(): ArrayList<Student>{
        var studentsList = arrayListOf<Student>()
        try {
            val parser = XMLParser()
            val inputStream = assets.open("studentdetails.xml")
            studentsList = parser.parse(inputStream)
        } catch (e: Exception){ e.printStackTrace() }
        return studentsList
    }
}