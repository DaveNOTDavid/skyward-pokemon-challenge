package com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davenotdavid.skywardpokemonchallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonCardsFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonCardsFragment()
    }

    private lateinit var viewModel: PokemonCardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonCardsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}