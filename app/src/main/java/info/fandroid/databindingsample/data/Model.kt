package info.fandroid.databindingsample.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import info.fandroid.databindingsample.models.Book
import info.fandroid.databindingsample.network.BookApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Model (val string: String = "hello") {
    var list: MutableLiveData<List<Book>> = MutableLiveData <List<Book>>()

}