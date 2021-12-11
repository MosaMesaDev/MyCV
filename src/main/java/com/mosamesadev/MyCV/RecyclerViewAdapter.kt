package com.mosamesadev.myCV


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerViewAdapter(val userList: ArrayList<User>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(userList[position])
    }
    override fun getItemCount(): Int {
        return userList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {

            Glide.with(itemView.context)
                .load(user.CVRecyclerImage)
                .into(itemView.findViewById(R.id.CVRecyclerImage))

            val textViewName = itemView.findViewById<TextView>(R.id.firstname)
            val textViewLastname = itemView.findViewById<TextView>(R.id.lastname)

            textViewName.text = user.Firstname
            textViewLastname.text = user.Lastname
        }
    }
}