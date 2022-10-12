package de.syntaxinstitut.happycake.adapter


import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.data.model.Cake
import de.syntaxinstitut.happycake.databinding.ItemCakeBinding

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

    inner class ItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        val cakeimg = itemView.findViewById<ImageView>(R.id.RProdukt)
        val cakeText = itemView.findViewById<TextView>(R.id.textViewCake)
        val cakePrice = itemView.findViewById<TextView>(R.id.textViewPrice)
}

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cake, parent, false)

       // val binding = ItemCakeBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(itemLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // der aktuelle Artikel wird von der Liste geladen
        val item = dataset[position]


//ToDO: bilder laden FUNKT nich,
// test aus anderem Projekt lädt auch nicht FEHLE DEAD OBJECT EXEPTION
// Könnte das PRONBLEM sein??? INTERNET PERMISSEN IM MANIFEST?

//        holder.binding.fanImage.setImageResource(item.imageSrc)
/*val url = "https://public.syntax-institut.de/apps/AndreWagner/images/fan1.jpg"

        val imgUri = url.toUri().buildUpon().scheme("http").build()
    Log.d("image_debug",item.imageSrc)
        holder.cakeimg.load(imgUri)*/


        holder.cakeText.text = item.name
        holder.cakePrice.text = "€${item.price}"

//        if (item.sale) {
//            holder.binding.fanSaleText.visibility = View.VISIBLE
//            holder.binding.fanPriceText.setTextColor(ContextCompat.getColor(context, R.color.secondaryLightColor))
//            holder.binding.fanPriceText.textSize = 24F
//        } else {
//            holder.binding.fanSaleText.visibility = View.GONE
//            holder.binding.fanPriceText.setTextColor(ContextCompat.getColor(context, R.color.textColor))
//            holder.binding.fanPriceText.textSize = 20F
//        }

      /*  holder.binding..setOnClickListener {
//            holder.itemView.findNavController()
//                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(item.id))
        }*/
    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}
