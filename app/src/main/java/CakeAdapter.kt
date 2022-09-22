


import androidx.recyclerview.widget.RecyclerView

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
abstract class CakeAdapter(
    private val dataset: List<Item>
) : RecyclerView.Adapter<CakeAdapter.recyclerViewProdukte>() {}