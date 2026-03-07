package com.example.studentgradecalculator

/**
 * Object-Oriented approach for calculating grades.
 * Uses a Lambda for the grading logic to demonstrate functional programming.
 */
class GradeCalculator(
    private val gradingLogic: (Int) -> String = { score ->
        when (score) {
            in 90..100 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            in 60..69 -> "D"
            in 0..59 -> "F"
            else -> "Invalid"
        }
    }
) {
    fun calculate(score: Int): String {
        return gradingLogic(score)
    }
}
