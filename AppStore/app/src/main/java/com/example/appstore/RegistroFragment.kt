package com.example.appstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegistroFragment : Fragment(R.layout.fragment_registro) {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtName = requireView().findViewById<EditText>(R.id.txtName)
        val txtEmail = requireView().findViewById<EditText>(R.id.txtEmail)
        val txtPass1 = requireView().findViewById<EditText>(R.id.txtPass)
        val txtPass2 = requireView().findViewById<EditText>(R.id.txtConfPass)
        val btnReg = requireView().findViewById<Button>(R.id.btnReg)

        firebaseAuth = Firebase.auth

        btnReg.setOnClickListener {

            var pass1 = txtPass1.text.toString()
            var pass2 = txtPass2.text.toString()
            if (pass1.equals(pass2)){

            }else{
                //Toast.makeText(baseContext, "Error: los passwords no coinciden")
            }
            findNavController().navigate(R.id.action_registroFragment_to_loginFragment)
        }
    }
}