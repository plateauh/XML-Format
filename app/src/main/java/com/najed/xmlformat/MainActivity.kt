package com.najed.xmlformat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
        val studentsList = arrayListOf<Student>()
        studentsList.add(Student(1, "Najed", 20f))
        studentsList.add(Student(2, "n", 50f))
        studentsList.add(Student(3, "a", 50f))
        return studentsList
    }
}