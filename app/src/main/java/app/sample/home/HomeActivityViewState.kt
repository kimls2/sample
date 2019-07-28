package app.sample.home

import com.airbnb.mvrx.MvRxState

data class HomeActivityViewState(
    val loading: Boolean = false
) : MvRxState