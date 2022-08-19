package com.example.breakingbadapp

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.breakingbadapp.database.Quote

fun convertQuoteToString(quote: Quote?): String {
    return String.format("\"%s\" - %s", quote?.quote, quote?.author)
}

class TextItemViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
