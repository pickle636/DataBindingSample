package info.fandroid.databindingsample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.fandroid.databindingsample.data.Model
import info.fandroid.databindingsample.data.SimpleViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(val model: Model): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SimpleViewModel::class.java)){
            SimpleViewModel(model) as T
        }
        else {
            throw IllegalArgumentException()
        }
    }
}