package com.david.apicall


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.david.apicall.databinding.ActivityStudentBinding
import com.david.apicall.model.Student
import com.david.apicall.ui.MainActivityViewModel
import com.david.apicall.ui.StudentAdapter

class StudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentBinding
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        studentAdapter = StudentAdapter(listOf())
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.studentRecycler.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(this@StudentActivity)
        }

        viewModel.run {
            getStudents()
            studentLiveData.observe(this@StudentActivity, {student ->
                studentAdapter.students = student
                studentAdapter.notifyDataSetChanged()
            })

        }

        binding.addButton.setOnClickListener {
            addStudent()
        }
    }


    private fun addStudent() {
        val classNames = binding.classText.text.toString()
        val name = binding.nameText.text.toString()
        val seat = binding.seatText.text.toString()


        if (classNames.isNotEmpty() && name.isNotEmpty() && seat.isNotEmpty()) {
            //adding new student to server
            val newStudent = Student(classNames, name, seat)
            viewModel.addStudent(newStudent)
            Toast.makeText(this, "Successfully Added", Toast.LENGTH_LONG).show()

        } else {
            Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }
}