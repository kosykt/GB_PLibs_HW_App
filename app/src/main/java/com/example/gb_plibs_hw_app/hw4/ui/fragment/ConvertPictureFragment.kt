package com.example.gb_plibs_hw_app.hw4.ui.fragment

import android.graphics.Bitmap
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.gb_plibs_hw_app.App
import com.example.gb_plibs_hw_app.R
import com.example.gb_plibs_hw_app.databinding.FragmentConvertPictureBinding
import com.example.gb_plibs_hw_app.databinding.FragmentLoginBinding
import com.example.gb_plibs_hw_app.hw4.data.InternalStorageRepositoryImpl
import com.example.gb_plibs_hw_app.ui.base.BackButtonListener
import com.example.gb_plibs_hw_app.ui.users.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class ConvertPictureFragment : MvpAppCompatFragment(), ConvertPictureView, BackButtonListener {

    private var _binding: FragmentConvertPictureBinding? = null
    private val binding
        get() = _binding!!

    private val presenter by moxyPresenter {
        ConvertPicturePresenter(
            repository = InternalStorageRepositoryImpl(
                context = requireContext().applicationContext
            ), router = App.instance.router
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConvertPictureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getImageJPG()
    }

    override fun backPressed(): Boolean {
        presenter.backPressed()
        return true
    }

    override fun showImageJPG(bitmap: Bitmap) {

        binding.jpgIv.setImageBitmap(bitmap)

        binding.convertBtn.setOnClickListener {
            presenter.convertImageToPNG(bitmap)
        }
    }

    override fun showImagePNG(bitmap: Bitmap) {
        binding.pngIv.setImageBitmap(bitmap)
    }

    override fun showImagePNGLabel() {
        binding.statusTv.visibility = View.VISIBLE
    }

    override fun showError(errorMessage: String?) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }
}