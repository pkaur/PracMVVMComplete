package com.puneetkaur.pracmvvmcomplete.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.puneetkaur.pracmvvmcomplete.R
import com.puneetkaur.pracmvvmcomplete.model.Earthquake

class EarthquakeAdapter(var list: List<Earthquake>): RecyclerView.Adapter<EarthquakeAdapter.EarthquakeViewHolder>() {

    class EarthquakeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    lateinit var eqid: TextView
    lateinit var magnitude: TextView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EarthquakeViewHolder {
        return EarthquakeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    private var onItemClickListener: ((Earthquake) -> Unit)? = null

    fun setOnClickListener(listener: (Earthquake)-> Unit){
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: EarthquakeViewHolder, position: Int) {
        val result = list[position]

        eqid = holder.itemView.findViewById(R.id.eqid)
        magnitude = holder.itemView.findViewById(R.id.magnitude)

        eqid.text = result.eqid
        magnitude.text = result.magnitude.toString()

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(result)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitList(newlist: List<Earthquake>){
        list = newlist
        notifyDataSetChanged()
    }
}