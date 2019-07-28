package app.sample.home.main

import app.sample.data.entities.Comic
import com.airbnb.mvrx.MvRxState

data class MainViewState(
        val isLoading: Boolean = false,
        val comics: List<Comic> = emptyList()
) : MvRxState