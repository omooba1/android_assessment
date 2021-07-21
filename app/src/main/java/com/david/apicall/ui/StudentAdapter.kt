package com.david.apicall.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.david.apicall.databinding.StudentItemBinding
import com.david.apicall.model.Student

class StudentAdapter (var students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(private val binding: StudentItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(student: Student){
            binding.apply {
                classView.text = student.`class`
                nameView.text = student.name
                seatView.text = student.seat
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentItemBinding.inflate(LayoutInflater.from(parent.context))
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = students[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return students.size
    }
}