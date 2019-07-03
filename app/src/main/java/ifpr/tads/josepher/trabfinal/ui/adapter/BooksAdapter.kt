package ifpr.tads.josepher.trabfinal.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ifpr.tads.josepher.trabfinal.R
import ifpr.tads.josepher.trabfinal.entities.Book
import kotlinx.android.synthetic.main.livro_card.view.*

class BooksAdapter(var books: List<Book>): RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    override fun getItemCount()= books.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BookViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.livro_card, parent, false)
        )


    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.fillUI(books[position])
    }

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun fillUI(book: Book){
            itemView.txTitle.text = book.title
            itemView.txAuthor.text = book.althor.toString()
            itemView.txDescription.text = book.description
        }
    }
}