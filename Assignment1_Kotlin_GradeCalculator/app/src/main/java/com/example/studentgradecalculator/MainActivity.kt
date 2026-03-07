package com.example.studentgradecalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentgradecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    
    // OOP: List of Student objects
    private val studentList = mutableListOf<Student>()
    private lateinit var adapter: StudentAdapter
    
    // OOP & Lambda: GradeCalculator uses a lambda for logic
    private val calculator = GradeCalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(
                left = 16.dpToPx() + systemBars.left,
                top = 16.dpToPx() + systemBars.top,
                right = 16.dpToPx() + systemBars.right,
                bottom = 16.dpToPx() + systemBars.bottom
            )
            insets
        }

        binding.calculateButton.setOnClickListener {
            addStudentToSheet()
        }
    }

    private fun setupRecyclerView() {
        // Lambda: Passing a lambda to handle clicks on the "Excel Sheet" items
        adapter = StudentAdapter(studentList) { student ->
            // "When a student enter the sheet it gives another sheet"
            // Interpreted as: Clicking an entry opens a detailed view (simulated here)
            showStudentDetails(student)
        }
        
        binding.studentRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.studentRecyclerView.adapter = adapter
    }

    private fun addStudentToSheet() {
        val name = binding.nameInput.text.toString()
        val scoreText = binding.gradeInput.text.toString()
        val score = scoreText.toIntOrNull()

        // Validation
        if (name.isBlank()) {
            binding.nameInputLayout.error = getString(R.string.error_invalid_name)
            return
        }
        binding.nameInputLayout.error = null

        if (score == null || score !in 0..100) {
            binding.gradeInputLayout.error = getString(R.string.error_out_of_range)
            return
        }
        binding.gradeInputLayout.error = null

        // OOP: Creating a Student object
        val grade = calculator.calculate(score)
        val newStudent = Student(
            id = studentList.size + 1,
            name = name,
            score = score,
            grade = grade
        )

        // Adding to our "Sheet"
        studentList.add(0, newStudent) // Add to top
        adapter.notifyItemInserted(0)
        binding.studentRecyclerView.scrollToPosition(0)
        
        // Clear inputs
        binding.nameInput.text?.clear()
        binding.gradeInput.text?.clear()
        binding.nameInput.requestFocus()
    }

    private fun showStudentDetails(student: Student) {
        // Simulating "giving another sheet" / Opening a detail view
        Toast.makeText(
            this,
            "Opening Detailed Sheet for ${student.name}...",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun Int.dpToPx(): Int = (this * resources.displayMetrics.density).toInt()
}