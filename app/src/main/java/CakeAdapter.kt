


import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.happycake.data.model.Cake

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
abstract class CakeAdapter(
    private val dataset: List<Cake>
) : RecyclerView.Adapter<CakeAdapter.ItemViewHolder>() {}