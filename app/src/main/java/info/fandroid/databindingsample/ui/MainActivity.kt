package info.fandroid.databindingsample.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import info.fandroid.databindingsample.BookRecyclerBookAdapter
import info.fandroid.databindingsample.R
import info.fandroid.databindingsample.ViewModelFactory
import info.fandroid.databindingsample.data.Model
import info.fandroid.databindingsample.data.SimpleViewModel
import info.fandroid.databindingsample.databinding.ActivityMainBinding
import info.fandroid.databindingsample.models.Book

class MainActivity : AppCompatActivity() {

    private var viewModelFactory = ViewModelFactory(Model())
    private val viewModel by lazy { ViewModelProvider(this, viewModelFactory).get(SimpleViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adapter = BookRecyclerBookAdapter(this, mutableListOf<Book>())

        binding.adapter = adapter
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.list?.observe(this, Observer { bookList ->
            adapter.onChange(bookList)
        })
    }
}
