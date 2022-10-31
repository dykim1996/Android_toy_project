package com.greedy.vincent

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.greedy.template.API.Item
import com.greedy.vincent.databinding.PostRecyclerBinding


class PostsAdapter(var itemList: MutableList<Item?>) : RecyclerView.Adapter<PostHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        return PostHolder(PostRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return if (itemList == null) 0 else itemList!!.size
    }

    override fun onBindViewHolder(viewHolder: PostHolder, position: Int) {
        val item = itemList!![position]
        viewHolder.setItem(item)
    }

}

class PostHolder(val binding: PostRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {

    private lateinit var item: Item

    init {
        binding.root.setOnClickListener {
            val intent = Intent(it.context, PostDetailActivity::class.java)

            intent.putExtra("facltNm",item.facltNm)
            intent.putExtra("induty",item.induty)
            intent.putExtra("addr1",item.addr1)
            intent.putExtra("lineIntro",item.lineIntro)
            intent.putExtra("intro", item.intro)
            intent.putExtra("sbrsCl",item.sbrsCl)
            intent.putExtra("firstImageUrl", item.firstImageUrl)
            it.context.startActivity(intent)
        }
    }

    fun setItem(item: Item?) {
        binding.title.text = "${item?.contentId}. ${item?.facltNm}"
        binding.address.text = "${item?.addr2}"
        binding.address2.text = "${item?.addr1}"

        Glide.with(binding.imageView).load(item?.firstImageUrl).into(binding.imageView)

        this.item = item!!
    }

}