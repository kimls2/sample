package app.sample.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingItemDecorator(
        left: Int = 0,
        top: Int = 0,
        right: Int = 0,
        bottom: Int = 0
) : RecyclerView.ItemDecoration() {

    constructor(spacing: Int) : this(spacing, spacing, spacing, spacing)

    private val spacingRect = Rect()

    init {
        spacingRect.set(left, top, right, bottom)
    }

    override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
    ) {
        outRect.set(spacingRect)
    }
}
