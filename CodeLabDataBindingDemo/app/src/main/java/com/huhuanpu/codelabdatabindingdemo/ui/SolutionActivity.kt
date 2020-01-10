package com.huhuanpu.codelabdatabindingdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.huhuanpu.codelabdatabindingdemo.R
import com.huhuanpu.codelabdatabindingdemo.data.SimpleViewModelSolution
import com.huhuanpu.codelabdatabindingdemo.databinding.SolutionBinding


/**
 * Created by huhuanpu on 20-1-10
 */

class SolutionActivity : AppCompatActivity() {

    // Obtain ViewModel from ViewModelProviders
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModelSolution::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: SolutionBinding = DataBindingUtil.setContentView(this, R.layout.solution)

        binding.lifecycleOwner = this // use fragment.viewLifecycleOwner for fragments

        binding.viewmodel = viewModel

    }
}