package de.syntaxinstitut.happycake.adapter


import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.data.model.Cake
import de.syntaxinstitut.happycake.databinding.ItemCakeBinding
import de.syntaxinstitut.happycake.ui.HomeFragmentDirections

// diesmal benötigt der Adapter den Context um auf die ColorResources zuzugreifen
class CakeAdapter(
    private val dataset: List<Cake>
) : RecyclerView.Adapter<CakeAdapter.ItemViewHolder>() {

    //private var dataset = emptyList<Cake>()

 /*   @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Cake>) {
        dataset = list
        notifyDataSetChanged()
    }*/

    // der ViewHolder kann über die DatabBinding Variable auf alle Layoutelemente zugreifen
   // class ItemViewHolder(val binding: ItemCakeBinding) : RecyclerView.ViewHolder(binding.root)

    inner class ItemViewHolder(val binding: ItemCakeBinding):RecyclerView.ViewHolder(binding.root){


       /* val cakeimg = itemView.findViewById<ImageView>(R.id.RProdukt)
        val cakeText = itemView.findViewById<TextView>(R.id.textViewCake)
        val cakePrice = itemView.findViewById<TextView>(R.id.textViewPrice)
        val weiter_button = itemView.findViewById<Button>(R.id.button_weiter)*/
}

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        //     val itemLayout = LayoutInflater.from(parent.context)
        //    .inflate(R.layout.item_cake, parent, false)

       val binding = ItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
        // und in einem ViewHolder zurückgegeben
       // return ItemViewHolder(itemLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // der aktuelle Artikel wird von der Liste geladen
        val item = dataset[position]


        val imgUri = item.imageSrc.toUri().buildUpon().scheme("https").build()
        //TEST
        //println("imgUri: $imgUri")
        holder.binding.RProdukt.load(imgUri)
        holder.binding.textViewCake.text = item.name
        holder.binding.textViewPrice.text = "€${item.price}"




        holder.binding.cardView.setOnClickListener {
            holder.itemView.findNavController()
               .navigate(HomeFragmentDirections.actionHomeFragmentToCakeDetailFragment(item.name))
        }
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
