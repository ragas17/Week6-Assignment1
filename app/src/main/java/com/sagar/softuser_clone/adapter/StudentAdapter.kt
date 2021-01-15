package com.sagar.softuser_clone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sagar.softuser_clone.R
import com.sagar.softuser_clone.model.Student
import com.sagar.softuser_clone.ui.home.HomeFragment
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(private val studentList: MutableList<Student>?,
                     private val selectedContext: HomeFragment): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(view: View,
                            val profile: CircleImageView = view.findViewById(R.id.studentProfile),
                            val name: TextView = view.findViewById(R.id.tvName),
                            val age: TextView = view.findViewById(R.id.tvAge),
                            val address: TextView = view.findViewById(R.id.tvAddress),
                            val gender: TextView = view.findViewById(R.id.tvGender),
                            val delete: ImageView = view.findViewById(R.id.icDelete)) : RecyclerView.ViewHolder(view){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.student_tab, parent, false)
        return StudentViewHolder(view)
    }
    override fun getItemCount(): Int {
        return studentList?.size!!
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList?.get(position)
        holder.name.text = student?.name
        holder.age.text = student?.age
        holder.address.text = student?.address
        holder.gender.text = student?.gender

        Glide.with(selectedContext).load(student?.profilePicture.toString()).into(holder.profile)

        holder.profile.setOnClickListener(){
            Toast.makeText(it.context, "Hello from ${student?.name}", Toast.LENGTH_LONG).show()
        }

        holder.delete.setOnClickListener(){
            val studentAtIndex = studentList?.indexOf(student)!!
            removeStudent(studentAtIndex)
        }
    }

    private fun removeStudent(position: Int){
        if (position >= studentList?.size!!) return;

        studentList?.removeAt(position);
        notifyItemRemoved(position);
    }
}