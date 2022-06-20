package cl.demo.rickandmortydemo.ui.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.demo.rickandmortydemo.R
import cl.demo.rickandmortydemo.domain.model.Characters

class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>(){

    private var charactersList =  ArrayList<Characters>()
    private lateinit var listener: MiOnClickListener

    interface MiOnClickListener{
        fun onClickListener(id: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return CharacterViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindData(charactersList[position])
    }

    override fun getItemCount(): Int = charactersList.size

    fun updateData(charactersList: List<Characters>)
    {
        this.charactersList = charactersList as ArrayList<Characters>
        notifyDataSetChanged()
    }

    fun setMiOnClickListener(listener:MiOnClickListener)
    {
        this.listener = listener
    }

}