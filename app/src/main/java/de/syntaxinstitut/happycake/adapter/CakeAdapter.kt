package de.syntaxinstitut.happycake.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.data.model.Cake
import de.syntaxinstitut.happycake.databinding.ItemCakeBinding
import de.syntaxinstitut.happycake.ui.HomeFragmentDirections

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 *
 */
class CakeAdapter(
    private val dataset: List<Cake>
) : RecyclerView.Adapter<CakeAdapter.ItemViewHolder>() {

    private lateinit var binding:ItemCakeBinding

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(binding: ItemCakeBinding) : RecyclerView.ViewHolder(binding.root){
        val ivPicture: ImageView = itemView.findViewById(R.id.HappyBDay)
        val tvName: TextView = itemView.findViewById(R.id.textViewCake)

}
    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
        val binding = ItemCakeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // Setze das richtige Bild und den richtigen Namen
        val cake = dataset[position]
       holder.ivPicture.setImageResource(cake.imageResId)
       holder.tvName.text = cake.name

        binding.textViewCake.setOnClickListener{holder.itemView.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToCakeDetailFragment()
        )}

//Setze einen onClickListener auf das Layout und navigiere darin zum
        /*holder.? Cake ?.setOnClickListener {
            holder.itemView.findNavController().navigate(
                HomeFragmentDirection.actionHomeFragmentTo
            )
        }*/

    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}