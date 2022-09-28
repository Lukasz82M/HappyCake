package Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.happycake.R
import de.syntaxinstitut.happycake.data.model.Cake
import de.syntaxinstitut.happycake.ui.HomeFragment
import java.text.FieldPosition

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class CakeAdapter(
    private val dataset: List<Cake>
) : RecyclerView.Adapter<CakeAdapter.ItemViewHolder>(){


/**
 * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
 */
inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivPicture: ImageView = itemView.findViewById(R.id.HappyBDay)
    val tvName: TextView = itemView.findViewById(R.id.textViewCake)

}

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        TODO("Not yet implemented")
        val itemLayout  =LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cake, parent, false)

        return ItemViewHolder(itemLayout)
    }
}

/**
 * hier findet der Recyclingprozess statt
 * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
 */
override fun onBindViewHolder(holder: CakeAdapter.ItemViewHolder, position: Int) {
    // Setze das richtige Bild und den richtigen Namen
    val cake = dataset[position]
    holder.ivPicture.setImageResource(dataset[position].imageResId)
    holder.tvName.text = dataset[position].name
}

//Setze einen onClickListener auf das Layout und navigiere darin zum
holder.?Cake?.setOnClickListener {
    holder.itemView.findNavController().navigation(
        HomeFragmentDirection.actionHomeFragmentTo
    )
}

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size