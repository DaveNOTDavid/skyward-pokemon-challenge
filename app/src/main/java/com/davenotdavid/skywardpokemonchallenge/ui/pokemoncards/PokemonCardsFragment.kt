package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.davenotdavid.skywardpokemonchallenge.databinding.FragmentPokemonCardsBinding
import com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards.adapter.PokemonCardsAdapter
import com.davenotdavid.skywardpokemonchallenge.util.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonCardsFragment : Fragment() {

    private lateinit var binding: FragmentPokemonCardsBinding
    private val viewModel by viewModels<PokemonCardsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonCardsBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sets the lifecycle owner to observe LiveData changes within this fragment's
        // lifecycle binding that then updates the UI.
        binding.lifecycleOwner = this.viewLifecycleOwner

        setupPokemonCardAdapter()
        setupNavigation()
    }

    private fun setupPokemonCardAdapter() {
        val viewModel = binding.viewmodel
        if (viewModel != null) {
            val adapter = PokemonCardsAdapter(viewModel)
            binding.pokemonCardList.adapter = adapter
        } else {
            Log.w("tag", "Failed to set up article adapter with ViewModel")
        }
    }

    private fun setupNavigation() {
        viewModel.openCardDetailsEvent.observe(viewLifecycleOwner, EventObserver { cardId ->
            goToCardDetailScreen(cardId)
        })
    }

    private fun goToCardDetailScreen(cardId: String) {
        val action = PokemonCardsFragmentDirections.actionCardsFragmentToCardDetailFragment(cardId)
        findNavController().navigate(action)
    }

}
