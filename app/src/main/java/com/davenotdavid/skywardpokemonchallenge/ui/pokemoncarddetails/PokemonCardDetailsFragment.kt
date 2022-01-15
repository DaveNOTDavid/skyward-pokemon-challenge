package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncarddetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.davenotdavid.skywardpokemonchallenge.databinding.FragmentPokemonCardDetailsBinding
import com.davenotdavid.skywardpokemonchallenge.util.EventObserver
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

        viewModel.apply {
            getCardDetails(cardDetailArgs.cardId)

            openCardPageEvent.observe(viewLifecycleOwner, EventObserver { url ->
                goToCardPage(url)
            })
        }
    }

    private fun goToCardPage(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW)
        browserIntent.data = Uri.parse(url)
        startActivity(browserIntent)
    }

}
