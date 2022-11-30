package org.com.testing.with.simpletest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * TODO: Implement the Adapter that will populate a RecyclerView using the information generated in ViewModel
 * */

class RVCustomAdapter : RecyclerView.Adapter<ViewHolder>() {
    var dataSet = mutableListOf<Article>()

    fun setDataList(list: MutableList<Article>) {
        this.dataSet = list.toMutableList()
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val data = dataSet[position]

        viewHolder.mTextViewTitle.text = data.title

        viewHolder.mTextViewContent.text = data.content

        Picasso.get().load(data.imageURL.toString()).into(viewHolder.mImageViewCardViewItem)
    }
    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size
}
class ViewHolder(listView: View) : RecyclerView.ViewHolder(listView) {

    val mImageViewCardViewItem: ImageView?
    val mTextViewTitle: TextView
    val mTextViewContent: TextView
    init {

        // Define click listener for the ViewHolder's View.
        mImageViewCardViewItem = listView.findViewById(R.id.mImageViewCardViewItem)
        mTextViewTitle = listView.findViewById(R.id.mTextViewTitle)
        mTextViewContent = listView.findViewById(R.id.mTextViewContent)
    }
}
