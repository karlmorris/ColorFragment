package edu.temple.colorfragment

import android.graphics.Color
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(_colors: Array<String>) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    val colors = _colors

    class ColorViewHolder(_textView: TextView) : RecyclerView.ViewHolder(_textView) {
        val colorNameTextView = _textView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(
            TextView(parent.context)
        )
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.colorNameTextView.text = colors[position]
        holder.colorNameTextView.setBackgroundColor(
            Color.parseColor(
                colors[position]
            )
        )
    }

    override fun getItemCount(): Int {
        return colors.size
    }
}