package com.example.week8
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week8.databinding.ItemProductBinding

class GVAdapter(private val context: Context, private val dataList: ArrayList<ProductData>) : RecyclerView.Adapter<GVAdapter.DataViewHolder>() {
    private var listener: OnItemClickListener? = null

    inner class DataViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            Log.d("CHECK DATA",dataList[position].title)
            binding.tvProductTitle.text = dataList[position].title
            Glide.with(context).load(dataList[position].images[0]).into(binding.ivProductImage)
            binding.rbProductRating.rating = dataList[position].rating.toFloat()
            binding.tvProductScore.text = dataList[position].rating.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(position)
        if(position != RecyclerView.NO_POSITION){
            holder.itemView.setOnClickListener{
                listener?.onItemClick(holder.itemView, dataList[position],position)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }
    interface OnItemClickListener {
        fun onItemClick(v: View, data: ProductData, position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }
}