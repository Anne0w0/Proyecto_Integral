package com.example.appstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class ListaFragment : Fragment(R.layout.fragment_lista) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = requireView().findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_listaFragment_to_loginFragment)
        }
    }
}