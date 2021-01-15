package com.sagar.softuser_clone.model

import com.sagar.softuser_clone.R

//https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLy446VMbnrng4120a90w_dicimYigWg_Rwg&usqp=CAU
//https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR6lFDIULYuu_GFt1Zoe0LMj2SSUwXi6Hu23Q&usqp=CAU

class Database
private constructor(){
    //creating built-in student data
    private val student1 = Student(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXSvUNIKR8I-tkHtrWiC-XCELNLU96wzakSA&usqp=CAU",
        "Un Known", "20", "Kapan, Kathmandu", "Male"
    )
    private val student2 = Student(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQr5LUwXsGif_zOEuIog9I-WslOcaM09mt1wg&usqp=CAU",
        "Anon Ymous", "22", "Tokyo, Japan", "Male"
    )
    private val student3 = Student(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeI5j6M09iaZ3M9QI9E7qTYc3E707zVa8r9Q&usqp=CAU",
        "Fil Le", "19", "Paris, France", "Female"
    )

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