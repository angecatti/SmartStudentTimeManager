package com.example.studentgradecalculator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentgradecalculator.databinding.ItemStudentBinding

class StudentAdapter(
    private val students: List<Student>,
    private val onItemClick: (Student) -> Unit // Lambda function for item clicks
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.binding.studentName.text = student.name
        holder.binding.studentScore.text = student.score.toString()
        holder.binding.studentGrade.text = student.grade

        holder.itemView.setOnClickListener {
            onItemClick(student) // Invoking the lambda
        }
    }

    override fun getItemCount() = students.size
}