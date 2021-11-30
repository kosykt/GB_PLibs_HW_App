package com.example.gb_plibs_hw_app.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gb_plibs_hw_app.databinding.FragmentLoginBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class LoginFragment(private val login: String) : MvpAppCompatFragment(), LoginView {

    private var _binding: FragmentLoginBinding? = null
    private val binding
        get() = _binding!!

    private val presenter by moxyPresenter { LoginPresenter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.setLogin(login = login)
    }

    override fun setLoginTo(param: String) {
        binding.loginTv.text = param
    }

}