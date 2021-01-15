package com.sagar.softuser_clone.ui.register

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sagar.softuser_clone.R
import com.sagar.softuser_clone.model.Database
import com.sagar.softuser_clone.model.Student
import de.hdodenhof.circleimageview.CircleImageView


class RegisterFragment : Fragment(), View.OnClickListener {

    private lateinit var name: EditText
    private lateinit var age: EditText
    private lateinit var address: EditText
    private lateinit var grpGender: RadioGroup
    private lateinit var genderError: TextView
    private lateinit var studentProfile: EditText
    private lateinit var register: Button

    private lateinit var root: View

    private var checkedRadioId: Int = 0
    private lateinit var selectedGender: RadioButton

    private var validationRequired = true
    private lateinit var student: Student
    private lateinit var studentData: MutableList<Student>

    private var profileImage = ""

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_register, container, false)
        name = root.findViewById(R.id.etName)
        age = root.findViewById(R.id.etAge)
        address = root.findViewById(R.id.etAddress)
        grpGender = root.findViewById(R.id.rgGender)
        genderError = root.findViewById(R.id.showGenderError)
        studentProfile = root.findViewById(R.id.etProfile)
        register = root.findViewById(R.id.btnRegister)

        register.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        validationRequired()
        profileAssigner()
        if (!validationRequired){
            student = Student(profileImage, name.text.toString(), age.text.toString(),
                address.text.toString(), selectedGender.text.toString())
            studentData = Database.instance?.studentData!!
            studentData.add(student)
            showUserRegistered()
            clearTexts()
        }
    }

    private fun validationRequired(){
        //get the selected radio button in radio group
        checkedRadioId = grpGender.checkedRadioButtonId
        if (checkedRadioId != -1){
            selectedGender = root.findViewById(checkedRadioId)
        }

        validationRequired = true
        when {
            name.text.toString().isEmpty() -> {
                name.error = "Student name required."
                name.requestFocus()
            }
            age.text.toString().isEmpty() -> {
                age.error = "Student age required."
                age.requestFocus()
            }
            address.text.toString().isEmpty() -> {
                address.error = "Student address required."
                address.requestFocus()
            }
            checkedRadioId == -1 -> {
                genderError.error = ""
            }
            else -> {
                validationRequired = false
            }
        }
    }

    private fun profileAssigner(){
        if (studentProfile.text.toString() == ""){
            profileImage = when {
                selectedGender.text.toString() == "Male" -> {
                    "data:image/jpeg;base64,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"
                }
                selectedGender.text.toString() == "Female" -> {
                    "data:image/jpeg;base64,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"
                }
                else -> {
                    "data:image/png;base64,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"
                }
            }
        }
        else{
            profileImage = studentProfile.text.toString()
        }
    }

    private fun showUserRegistered(){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Register")
        builder.setMessage("Student successfully registered.")

        builder.setPositiveButton("Okay"){ _, _ -> clearTexts() }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(true)
        alertDialog.show()
    }

    private fun clearTexts(){
        name.text.clear()
        age.text.clear()
        address.text.clear()
        grpGender.clearCheck()
    }
}