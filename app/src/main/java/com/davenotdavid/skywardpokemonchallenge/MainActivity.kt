package com.davenotdavid.skywardpokemonchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.davenotdavid.skywardpokemonchallenge.ui.pokemoncards.PokemonCardsFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Marks an Android component class to be setup for injection with the standard
 * Hilt Dagger Android components.
 *
 * TODO: Set up nav components
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, PokemonCardsFragment.newInstance())
                .commitNow()
        }
    }
}