package info.fandroid.databindingsample.repositiry

import android.util.Log
import androidx.lifecycle.LiveData

import info.fandroid.databindingsample.network.RetrofitBuilder
import info.fandroid.databindingsample.models.Book
import kotlinx.coroutines.*

object Repository {

    var job: CompletableJob? = null

    fun getBooks(): LiveData<List<Book>> {
        println("dfdffdf")
        job = Job()
        return object: LiveData<List<Book>>(){
            override fun onActive() {
                super.onActive()
                job?.let{ theJob ->
                    CoroutineScope(Dispatchers.IO + theJob).launch {
                        val book = RetrofitBuilder.bookApiService().getBooks()
                        println("$book !!!!????")
                        withContext(Dispatchers.Main){
                            value = book
                            theJob.complete()
                        }
                    }
                }
//                val book = Book(4455, "sdgsdfg", "dfdf","dfdfdf", 55)
//                val list = mutableListOf(book)
//                value = list
            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

}