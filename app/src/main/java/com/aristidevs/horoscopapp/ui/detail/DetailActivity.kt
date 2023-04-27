package com.aristidevs.horoscopapp.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.aristidevs.horoscopapp.databinding.ActivityDetailBinding
import com.aristidevs.horoscopapp.ui.detail.model.DetailUIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    companion object {
        fun create(context: Context) = Intent(context, DetailActivity::class.java)
    }

    private val viewModel by viewModels<DetailViewModel>()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        viewModel.getHoroscope()
    }

    private fun initUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { uiState ->
                    when (uiState) {
                        is DetailUIState.Error -> {
                            binding.loading.isVisible = false
                        }

                        DetailUIState.Loading -> {
                            binding.loading.isVisible = true
                        }

                        is DetailUIState.Success -> {
                            binding.loading.isVisible = false
                            Toast.makeText(this@DetailActivity, uiState.horoscopeModel.horoscope, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            }
        }
    }
}