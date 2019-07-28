package app.sample.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import app.sample.R
import app.sample.base.BaseActivityMvRxView
import app.sample.databinding.ActivityHomeBinding
import com.airbnb.mvrx.viewModel
import com.airbnb.mvrx.withState
import javax.inject.Inject

class HomeActivity : BaseActivityMvRxView() {
    @Inject
    lateinit var homeActivityViewModelFactory: HomeActivityViewModel.Factory

    private val viewModel: HomeActivityViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding

    private val navController: NavController
        get() = (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        navController.addOnDestinationChangedListener { _, _, _ ->
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.subscribe(this) { postInvalidate() }
    }

    override fun invalidate() {
        withState(viewModel) {
            binding.state = it
        }
    }
}