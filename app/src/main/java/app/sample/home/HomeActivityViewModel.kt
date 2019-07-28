package app.sample.home

import app.sample.base.BaseViewModel
import app.sample.util.AppRxSchedulers
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class HomeActivityViewModel @AssistedInject constructor(
    @Assisted initialState: HomeActivityViewState,
    @Suppress("UNUSED_PARAMETER") schedulers: AppRxSchedulers
) : BaseViewModel<HomeActivityViewState>(initialState) {
    @AssistedInject.Factory
    interface Factory {
        fun create(initialState: HomeActivityViewState): HomeActivityViewModel
    }

    companion object : MvRxViewModelFactory<HomeActivityViewModel, HomeActivityViewState> {
        override fun create(viewModelContext: ViewModelContext, state: HomeActivityViewState): HomeActivityViewModel? {
            val activity: HomeActivity = viewModelContext.activity()
            return activity.homeActivityViewModelFactory.create(state)
        }
    }
}