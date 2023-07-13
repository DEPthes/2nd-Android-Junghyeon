package com.example.week8

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.week8.databinding.ActivityProductDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    private lateinit var productData: ProductData
    private lateinit var imageAdapter: RVAdapter
    private var imageList: ArrayList<String> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        productData = intent.getSerializableExtra("product") as ProductData
        Glide.with(this).load(productData.images[0]).into(binding.ivProductDetailImage)
        binding.tvDetailBrand.text = productData.brand
        binding.rbDetailRating.rating = productData.rating.toFloat()
        binding.tvDetailScore.text = productData.rating.toString()
        binding.tvDetailTitle.text = productData.title
        binding.tvDetailPrice.text = productData.price.toString()+"$"
        binding.tvDetailScript.text = productData.description
        binding.ibDetailBack.setOnClickListener {
            finish()
        }
        showImages()
        clickImageList()
    }
    private fun setAdapter(){
        imageAdapter = RVAdapter(this,imageList)
        binding.rvDetailImageList.adapter = imageAdapter
        binding.rvDetailImageList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
    private fun showImages(){
        for(i in 0 until productData.images.size){
            imageList.add(productData.images[i])
        }
        setAdapter()
    }
    private fun clickImageList(){
        imageAdapter.setOnItemClickListener(object: RVAdapter.OnItemClickListener{
            override fun onItemClick(v: View, data: String, position: Int) {
                Glide.with(this@DetailActivity).load(data).into(binding.ivProductDetailImage)
            }
        })
    }
}