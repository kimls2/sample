package app.sample.home.main

import androidx.lifecycle.viewModelScope
import app.sample.base.BaseViewModel
import app.sample.data.entities.Comic
import app.sample.interactors.ObserveComics
import app.sample.interactors.UpdateComics
import app.sample.interactors.execute
import app.sample.util.RxLoadingCounter
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel @AssistedInject constructor(
    @Assisted initialState: MainViewState,
    observeComics: ObserveComics,
    private val updateComics: UpdateComics
) : BaseViewModel<MainViewState>(initialState) {
    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: MainViewState): MainViewModel
    }

    companion object : MvRxViewModelFactory<MainViewModel, MainViewState> {
        override fun create(viewModelContext: ViewModelContext, state: MainViewState): MainViewModel? {
            val fragment: MainFragment = (viewModelContext as FragmentViewModelContext).fragment()
            return fragment.mainViewModelFactory.create(state)
        }
    }

    private val loadingState = RxLoadingCounter()

    init {
        loadingState.observable
                .execute { copy(isLoading = it() ?: false) }
        observeComics.observe()
                .execute { copy(comics = it() ?: emptyList()) }
        observeComics.invoke(Unit)
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            try {
                updateComics.execute(Unit)
            } catch (e: Exception) {
                Timber.e(e)
            }
        }
    }

    fun onItemClicked(comic: Comic) {
    }
}