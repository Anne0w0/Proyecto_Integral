package com.example.appstore

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var authStateListener : FirebaseAuth.AuthStateListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        val btnLogin = requireView().findViewById<Button>(R.id.btnLogin)
        val btnReg = requireView().findViewById<Button>(R.id.btnReg)
        val txtemail = requireView().findViewById<EditText>(R.id.txtEmail)
        val txtpassword = requireView().findViewById<EditText>(R.id.txtPass)

        btnLogin.setOnClickListener {
            singIn(txtemail.text.toString(), txtpassword.text.toString())
        }

        btnReg.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }

    private fun singIn( email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener{ task ->
            if (task.isSuccessful) {
                val user = firebaseAuth.currentUser
                println(user?.uid.toString())
                //cambiamos de vista
                findNavController().navigate(R.id.action_loginFragment_to_listaFragment)
            } else {
                println("No se pudo conectar")
            }
        }
    }
}