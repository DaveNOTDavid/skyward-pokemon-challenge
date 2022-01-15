package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncarddetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.davenotdavid.skywardpokemonchallenge.databinding.FragmentPokemonCardDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonCardDetailsFragment : Fragment() {

    private lateinit var binding: FragmentPokemonCardDetailsBinding
    private val cardDetailArgs: PokemonCardDetailsFragmentArgs by navArgs()
    private val viewModel by viewModels<PokemonCardDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonCardDetailsBinding.inflate(inflater, container, false).apply {
            viewmodel = viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = this.viewLifecycleOwner

        viewModel.getCardDetails(cardDetailArgs.cardId)
    }

}
