package com.ainuribatov.learnandroid

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.ainuribatov.learnandroid.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val viewModel: MainViewModel by viewModels()

    private val viewBinding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adapter = setupRecyclerView()

        viewBinding.userListRecyclerView.isVisible = false
        viewBinding.progressBar.isVisible = true

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewState.collect {
                    when (it) {
                        is MainViewModel.ViewState.Loading -> {
                            viewBinding.userListRecyclerView.isVisible = false
                            viewBinding.progressBar.isVisible = true
                        }
                        is MainViewModel.ViewState.Data -> {
                            adapter.userList = it.userList
                            adapter.notifyDataSetChanged()
                            viewBinding.userListRecyclerView.isVisible = true
                            viewBinding.progressBar.isVisible = false
                        }
                    }
                }


            }
        }

    }

    private fun setupRecyclerView(): ListAdapter {
        val recyclerView = findViewById<RecyclerView>(R.id.userListRecyclerView)
        val adapter = ListAdapter()
        recyclerView.adapter = adapter
        return adapter
    }
}