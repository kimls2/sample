package app.sample.home.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.sample.base.BaseFragment
import app.sample.data.entities.Comic
import app.sample.databinding.FragmentMainBinding
import app.sample.ui.SpacingItemDecorator
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import javax.inject.Inject

class MainFragment : BaseFragment() {
    @Inject
    lateinit var mainViewModelFactory: MainViewModel.Factory

    private val viewModel: MainViewModel by fragmentViewModel()
    private lateinit var binding: FragmentMainBinding
    private lateinit var controller: MainEpoxyController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller = MainEpoxyController(object : MainEpoxyController.Callbacks {
            override fun onItemClicked(comic: Comic) {

            }
        })
        binding.mainRv.apply {
            addItemDecoration(SpacingItemDecorator(paddingLeft))
            setController(controller)
        }

        binding.btnRetry.setOnClickListener { viewModel.refresh() }
    }

    override fun invalidate() {
        withState(viewModel) {
            binding.state = it
            controller.setData(it)
        }
    }
}