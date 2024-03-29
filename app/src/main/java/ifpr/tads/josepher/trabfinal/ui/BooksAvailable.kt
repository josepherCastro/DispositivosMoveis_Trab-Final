package ifpr.tads.josepher.trabfinal.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import com.google.gson.GsonBuilder

import ifpr.tads.josepher.trabfinal.R
import ifpr.tads.josepher.trabfinal.entities.Book
import ifpr.tads.josepher.trabfinal.entities.volume.Volume
import ifpr.tads.josepher.trabfinal.services.BookService
import ifpr.tads.josepher.trabfinal.ui.adapter.BooksAdapter
import kotlinx.android.synthetic.main.fragment_books_available.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BooksAvailable : Fragment() {

    lateinit var service: BookService
    lateinit var adapter: BooksAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books_available, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRetrofit()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                loadBooks(query!!)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                loadBooks(newText!!)
                return true
            }

        })
        loadBooks()


    }

    private fun configureRetrofit(){
        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/books/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        service = retrofit.create<BookService>(BookService::class.java)
    }
    private fun loadBooks(query: String = ""){
        service.getLivro("isbn:$query").enqueue(object : Callback<Volume> {


            override fun onFailure(call: Call<Volume>, t: Throwable) {
                Log.e("ERRO", t.message, t)
            }

            override fun onResponse(call: Call<Volume>, response: Response<Volume>) {
                val items = response.body()?.items

                if(items!=null) {
                    val books = items[0].volumeInfo

                    loadRecyclerView(books)
                }
            }

        })
    }
    private fun loadRecyclerView(book: Book){
        if(listBooks != null){
            adapter = BooksAdapter(book)
            listBooks.adapter = adapter
        }
    }


}
