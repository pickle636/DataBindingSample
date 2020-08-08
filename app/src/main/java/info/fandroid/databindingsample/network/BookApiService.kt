package info.fandroid.databindingsample.network

import info.fandroid.databindingsample.models.Book
import retrofit2.http.GET

interface BookApiService {
    @GET("/api/books")
    suspend fun getBooks(): List<Book>
}