package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.davenotdavid.skywardpokemonchallenge.R
import com.davenotdavid.skywardpokemonchallenge.databinding.FragmentPokemonCardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonCardsFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonCardsFragment()
    }

    private lateinit var pokemonCardsBinding: FragmentPokemonCardsBinding
    private val pokemonCardsViewModel by viewModels<PokemonCardsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pokemonCardsBinding = FragmentPokemonCardsBinding.inflate(inflater, container, false).apply {
            viewModel = pokemonCardsViewModel
        }
        return pokemonCardsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sets the lifecycle owner to observe LiveData changes within this fragment's
        // lifecycle binding that then updates the UI.
        pokemonCardsBinding.lifecycleOwner = this.viewLifecycleOwner

        // TODO: Init
    }

}
