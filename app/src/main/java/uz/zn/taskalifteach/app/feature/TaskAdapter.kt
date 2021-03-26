//package com.example.alifteachtask.app.feature
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.Filter
//import android.widget.Filterable
//import androidx.recyclerview.widget.RecyclerView
//
//import com.example.alifteachtask.data.model.TaskEntity
//import com.example.alifteachtask.databinding.TaskItemBinding as Binding
//
//
//class TaskAdapter(context: Context) :
//        RecyclerView.Adapter<TaskAdapter.ViewHolder>(), Filterable{
//    private    val myList: MutableList<TaskEntity> = ArrayList()
//    private val inflater = LayoutInflater.from(context)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//       return ViewHolder(Binding.inflate(LayoutInflater.from(parent.context)))
//    }
//
//    override fun getItemCount(): Int {
//        return myList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.onBind(myList[position])
//    }
//
//
//    fun updateNews(newList: List<TaskEntity>) {
//        myList.clear()
//        myList.addAll(newList)
//        this.notifyDataSetChanged()
//    }
//
//    fun setProvidedPrice(newPrice: Int) {
////        price = newPrice;
//        notifyDataSetChanged()
//    }
//
//    class ViewHolder(private val binding: Binding) :
//            RecyclerView.ViewHolder(binding.root) {
//        private var selectSubject: TaskEntity? = null
//
//        fun onBind(newsItem: TaskEntity) {
//            this.selectSubject = newsItem
////
////            itemView.apply {
////                setOnClickListener { action.invoke(selectSubject!!) }
//
//
//                binding.tvTitle.text = newsItem.name
//                binding.tvCaption.text =newsItem.data
//            }
//
//        }
//
//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charSearch = constraint.toString()
//                if (charSearch.isEmpty()) {
//                    myList = myList as ArrayList<TaskEntity>
//                } else {
//                    val resultList = ArrayList<TaskEntity>()
//                    for (row in myList) {
//                        if (row.name!!.toLowerCase().contains(constraint.toString().toLowerCase())) {
//                            resultList.add(row)
//                        }
//                    }
//                    myList = resultList
//                }
//                val filterResults = FilterResults()
//                filterResults.values = myList
//                return filterResults
//            }
//
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                myList = results?.values as ArrayList<TaskEntity>
//                notifyDataSetChanged()
//            }
//        }
//    }
//
//}
//
//
//
