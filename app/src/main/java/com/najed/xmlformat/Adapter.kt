package com.najed.xmlformat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.najed.xmlformat.databinding.StudentItemBinding

class Adapter (private val students: ArrayList<Student>): RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: StudentItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(StudentItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val student = students[position]
        holder.binding.apply {
            studentIdTv.text = student.id.toString()
            studentNameTv.text = student.name
            studentMarkTv.text = student.mark.toString()
        }
    }

    override fun getItemCount() = students.size
}