package com.example.week8
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week8.databinding.ItemDetailImageListBinding

class RVAdapter (
    private val context: Context,
    private val dataList: ArrayList<String>
) : RecyclerView.Adapter<RVAdapter.DataViewHolder>() {
    private var listener: OnItemClickListener? = null

    inner class DataViewHolder(private val binding: ItemDetailImageListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            Glide.with(context).load(data).into(binding.ivProductDetailImageList)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding =
            ItemDetailImageListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
        if(position != RecyclerView.NO_POSITION){
            holder.itemView.setOnClickListener{
                listener?.onItemClick(holder.itemView,dataList[position],position)
            }
        }
    }
    override fun getItemCount(): Int = dataList.size
    override fun getItemViewType(position: Int): Int {
        return position
    }
    interface OnItemClickListener {
        fun onItemClick(v: View, data: String, position: Int)
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }
}
