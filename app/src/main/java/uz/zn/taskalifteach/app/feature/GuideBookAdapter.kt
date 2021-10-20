package uz.zn.taskalifteach.app.feature


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.zn.taskalifteach.R
import uz.zn.taskalifteach.data.model.Data
import uz.zn.taskalifteach.databinding.ViewHolderTaskItemBinding

import kotlin.collections.ArrayList

class GuideBookAdapter(val listenerAction: ListenerAction) :
    RecyclerView.Adapter<GuideBookAdapter.ViewHolder>(), Filterable {
    private var myList: MutableList<Data> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewHolderTaskItemBinding.inflate(LayoutInflater.from(parent.context)),
            listenerAction
        )
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(myList[position])
    }

    fun updateTask(newList: List<Data>) {
        myList.clear()
        myList.addAll(newList)
        this.notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ViewHolderTaskItemBinding,
        private val listenerAction: ListenerAction
    ) :
        RecyclerView.ViewHolder(binding.root) {
        private var selectSubject: Data? = null

        fun onBind(newsItem: Data) {
            this.selectSubject = newsItem

            itemView.apply {
//                Glide.with(itemView)
//                    .load(newsItem.icon)
//                    .centerCrop()
//                    .error(R.drawable.task)
//                    .into(binding.ivBookItemImage)
//                binding.imEdit.setOnClickListener {
//                    listenerAction.onUpdate(newsItem)
//                }
//                binding.imDelete.setOnClickListener {
//                    listenerAction.onDelete(newsItem)
//                }
                binding.tvSourceName.text = newsItem.name
                binding.tvEndDate.text = newsItem.endDate
//                if (newsItem.status == true) {
//                    binding.imStatus.setImageResource(R.drawable.ic_check__1_)
//                } else {
//                    binding.imStatus.setImageResource(R.drawable.ic_error)
//                }
            }
        }

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    myList = myList as ArrayList<Data>
                } else {
                    val resultList = ArrayList<Data>()
                    for (row in myList) {
                        if (row.name!!.toLowerCase()
                                .contains(constraint.toString().toLowerCase())
                        ) {
                            resultList.add(row)
                        }
                    }
                    myList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = myList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                myList = results?.values as ArrayList<Data>
                notifyDataSetChanged()
            }
        }
    }

    interface ListenerAction {
        fun onUpdate(taskEntity: Data)
        fun onDelete(taskEntity: Data)
    }
}









