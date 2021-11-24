package com.example.gb_plibs_hw_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gb_plibs_hw_app.databinding.ActivityMainBinding
import com.example.gb_plibs_hw_app.model.repository.NumListenerRepositoryImpl
import com.example.gb_plibs_hw_app.presenter.models.CounterModel
import com.example.gb_plibs_hw_app.presenter.usecase.ChangeNumOnButtonUseCase

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private val numListenerRepository by lazy { NumListenerRepositoryImpl() }
    private val changeNumOnButtonUseCase by lazy { ChangeNumOnButtonUseCase(numListenerRepository = numListenerRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        binding.mainBtn1.setOnClickListener {
            binding.mainTextView1.text
            var i = changeNumOnButtonUseCase.execute(
                param = CounterModel(
                    binding.mainTextView1.text.toString().toInt()
                )
            )
            binding.mainTextView1.text = i.toString()
        }

        binding.mainBtn2.setOnClickListener {
            binding.mainTextView2.text
            var i = changeNumOnButtonUseCase.execute(
                param = CounterModel(
                    binding.mainTextView2.text.toString().toInt()
                )
            )
            binding.mainTextView2.text = i.toString()
        }
    }

}


