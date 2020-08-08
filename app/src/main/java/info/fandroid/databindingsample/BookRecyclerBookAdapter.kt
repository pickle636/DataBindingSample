package info.fandroid.databindingsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import info.fandroid.databindingsample.databinding.TaskItemListBinding
import info.fandroid.databindingsample.models.Book

class BookRecyclerBookAdapter(private val context: Context, private val list: MutableList<Book>):
    RecyclerView.Adapter<BookRecyclerBookAdapter.BookItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        var view: View = LayoutInflater.from(context).inflate(R.layout.task_item_list, parent, false)
        return BookItemViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val book: Book = list[position]
        holder.bind(book)
    }

    class BookItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var binding: TaskItemListBinding? = null
        init {
            binding = DataBindingUtil.bind(itemView)
        }
        fun bind(o: Any){
            binding?.setVariable(BR.model1, o)
            binding?.executePendingBindings()

        }
    }
    fun onChange(list: List<Book>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}