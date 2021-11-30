package com.example.gb_plibs_hw_app.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gb_plibs_hw_app.databinding.FragmentLoginBinding
import moxy.MvpAppCompatFragment

class LoginFragment(login: String) : MvpAppCompatFragment() {

    companion object {
        fun newInstance(login: String) = LoginFragment(login)
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        Toast.makeText(context, "It's alive!", Toast.LENGTH_LONG).show()
        return binding.root
    }

}