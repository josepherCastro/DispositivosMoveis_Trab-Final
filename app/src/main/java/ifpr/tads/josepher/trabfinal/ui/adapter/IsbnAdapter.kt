package ifpr.tads.josepher.trabfinal.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import ifpr.tads.josepher.trabfinal.R
import ifpr.tads.josepher.trabfinal.entities.Book
import ifpr.tads.josepher.trabfinal.entities.Isbn
import ifpr.tads.josepher.trabfinal.entities.volume.Volume
import ifpr.tads.josepher.trabfinal.services.BookService
import ifpr.tads.josepher.trabfinal.ui.MyBookcase
import kotlinx.android.synthetic.main.cadastro_card.view.*
import kotlinx.android.synthetic.main.fragment_books_available.*
import kotlinx.android.synthetic.main.fragment_my_bookcase.*
import kotlinx.android.synthetic.main.livro_card.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IsbnAdapter:
    RecyclerView.Adapter<IsbnAdapter.IsbnViewHolder>() {

    lateinit var service: BookService
    lateinit var bookRegisterAdapter: BookRegisterAdapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IsbnViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.cadastro_card, parent, false)
        )

    override fun getItemCount()= 1

    override fun onBindViewHolder(holder: IsbnViewHolder, position: Int) {
        holder.fillUI()
    }
    inner class IsbnViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun fillUI(){

            configureRetrofit()

            itemView.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    loadBooks(query!!)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    loadBooks(newText!!)
                    return true
                }

            })
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
//            if( != null){
//                bookRegisterAdapter = BookRegisterAdapter(book)
//                listBooks.bookRegisterAdapter = bookRegisterAdapter
//            }
        }
    }
}