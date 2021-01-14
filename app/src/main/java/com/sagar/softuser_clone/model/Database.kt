package com.sagar.softuser_clone.model

import com.sagar.softuser_clone.R

class Database
private constructor(){
    //creating built-in student data
    private val student1 = Student(R.drawable.avatar4, "Un Known",
            "20", "Kapan, Kathmandu", "Male")
    private val student2 = Student(R.drawable.avatar2, "Anon Ymous",
            "22", "Tokyo, Japan", "Male")
    private val student3 = Student(R.drawable.avatar5, "Fil Le",
            "19", "Paris, France", "Female")

    //adding data
    var studentData = mutableListOf<Student>(student1, student2, student3)

    //making class directly accessible, without a need of making an object
    companion object{
        @get: Synchronized
        var instance: Database? = null
        get(){
            if (field == null){
                field = Database()
            }
            return field
        }
        private set
    }
}