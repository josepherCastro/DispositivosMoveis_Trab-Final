package ifpr.tads.josepher.trabfinal.services

import ifpr.tads.josepher.trabfinal.entities.Book
import ifpr.tads.josepher.trabfinal.entities.Volume
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BookService {
    @Headers("Accept: application/json")
    @GET("volumes")
    fun getLivro(
        @Query("q")
         isbn:String
    ): Call<Volume>
}