package com.github.kr328.clash.design.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.github.kr328.clash.design.util.layoutInflater
import com.github.kr328.clash.design.util.resolveThemedColor

class PopupListAdapter(
    private val context: Context,
    private val texts: List<CharSequence>,
    private val selected: Int,
) : BaseAdapter() {
    private val colorPrimaryContainer = context.resolveThemedColor(com.google.android.material.R.attr.colorPrimaryContainer)
    private val colorOnPrimaryContainer = context.resolveThemedColor(com.google.android.material.R.attr.colorOnPrimaryContainer)
    
    private val colorOnSurface = context.resolveThemedColor(com.google.android.material.R.attr.colorOnSurface)

    override fun getCount(): Int {
        return texts.size
    }

    override fun getItem(position: Int): Any {
        return texts[position]
    }

    override fun getItemId(position: Int): Long {
        return texts[position].hashCode().toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: context.layoutInflater
            .inflate(android.R.layout.simple_list_item_1, parent, false)

        val text: TextView = view.findViewById(android.R.id.text1)

        text.text = texts[position]

        if (position == selected) {
            text.setBackgroundColor(colorPrimaryContainer)
            text.setTextColor(colorOnPrimaryContainer)
        } else {
            text.setBackgroundColor(Color.TRANSPARENT)
            text.setTextColor(colorOnSurface)
        }

        return view
    }
}
