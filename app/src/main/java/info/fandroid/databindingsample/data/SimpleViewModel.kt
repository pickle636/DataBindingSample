package info.fandroid.databindingsample.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import info.fandroid.databindingsample.models.Book
import info.fandroid.databindingsample.repositiry.Repository

class SimpleViewModel(var model: Model) : ViewModel() {
    var list: LiveData<List<Book>>? = null

    init {
    println(Repository.getBooks())
        list = Repository.getBooks()
    }


}
