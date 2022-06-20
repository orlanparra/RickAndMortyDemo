package cl.demo.rickandmortydemo.ui.recyclerview

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import cl.demo.rickandmortydemo.databinding.ItemLayoutBinding
import cl.demo.rickandmortydemo.domain.model.Characters
import com.squareup.picasso.Picasso

class CharacterViewHolder(itemView: View, var listener: CharactersAdapter.MiOnClickListener) : RecyclerView.ViewHolder(itemView)
{
    private val binding: ItemLayoutBinding = ItemLayoutBinding.bind(itemView)

    fun bindData(character: Characters){
        with(binding)
        {
            Picasso.get().load(character.image).into(ivImageItem)
            tvNameItem.text = character.name
            tvSpecieItem.text = character.specie
            itemView.setOnClickListener {
                listener.onClickListener(character.id)
            }
        }
    }
}