package cn.hsp.demo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.hsp.demo.R
import cn.hsp.demo.network.response.Note
import kotlinx.android.synthetic.main.item_note.view.*

/**
 * 厦门大学计算机专业 | 前华为工程师
 * 专注《零基础学编程系列》https://cxyxy.blog.csdn.net/article/details/121134634
 * 包含：Java | 安卓 | 前端 | Flutter | iOS | 小程序 | 鸿蒙
 * 公众号：花生皮编程
 */
class NoteListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var onItemClick: (Note: Note) -> Unit
    private var dataList = mutableListOf<Note>()
    fun setData(noteList: List<Note>) {
        dataList.clear()
        dataList.addAll(noteList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        holder.itemView.textView.text = data.title
        holder.itemView.setOnClickListener { onItemClick(data) }
    }

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    infix fun setOnItemClick(onClick: (Note: Note) -> Unit) {
        this.onItemClick = onClick
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
}