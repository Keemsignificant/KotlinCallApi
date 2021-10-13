package keem.practice.develop.kotlincallapi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ItemAdapter(private val items:List<Data>, val context: Context?) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //setData

        holder.tvItem!!.text = items[position].content
        holder.tvTitleItem!!.text = items[position].title

        Picasso.get().load(items[position].pic).error(R.drawable.ic_launcher_background).into(holder.ivItem)
        holder.layoutItem.setOnClickListener(View.OnClickListener {

            //Toast.makeText(context, "ClickItem ${position}", Toast.LENGTH_SHORT ).show()


            var _bundle = Bundle()
            _bundle.putString("title", items[position].title)
            _bundle.putString("content", items[position].content)
            _bundle.putString("pic", items[position].pic)
            val activity= it.context as AppCompatActivity
            val mFragment = DetailFragment()
            mFragment.arguments = _bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.main_content, mFragment).addToBackStack(null).commit()
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

    var ivItem:ImageView = itemView.findViewById(R.id.ivItem)
    var tvTitleItem:TextView = itemView.findViewById(R.id.tvTitleItem)
    var tvItem:TextView = itemView.findViewById(R.id.tvItem)
    var layoutItem:LinearLayout = itemView.findViewById(R.id.layoutItem)

}