package app.sample.home.main

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import app.sample.comicGridItem
import app.sample.data.entities.Comic
import com.airbnb.epoxy.TypedEpoxyController
import com.bumptech.glide.Glide

class MainEpoxyController(
        private val callbacks: Callbacks
) : TypedEpoxyController<MainViewState>() {
    interface Callbacks {
        fun onItemClicked(comic: Comic)
    }

    override fun buildModels(state: MainViewState) {
        if (state.comics.isNotEmpty()) {
            state.comics.forEach {
                comicGridItem {
                    id(it.id)
                    comic(it)
                    clickListener { _ -> callbacks.onItemClicked(it) }
                }
            }
        }
    }
}

@BindingAdapter("marvelThumbnail")
fun loadMarvelImage(view: ImageView, thumbnailPath: String) {
    Glide.with(view).load(thumbnailPath).centerCrop().into(view)

}