package app.sample.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
        tableName = "comics",
        indices = [
            Index(value = ["marvel_comic_id"], unique = true)
        ]
)
data class Comic(
    @PrimaryKey(autoGenerate = true) @ColumnInfo override val id: Long = 0,
    @ColumnInfo(name = "marvel_comic_id") val marvelComicId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "thumbnail_path") val thumbnailPath: String,
    @ColumnInfo(name = "thumbnail_extension") val thumbnailFileType: String
) : SampleEntity {

    fun getThumbnailPathWithXlargeSize(): String {
        return "$thumbnailPath/$PORTRAIT_XLARGE.$thumbnailFileType"
    }

    fun getThumbnailPathWithDetailSize(): String {
        return "$thumbnailPath/$DETAIL.$thumbnailFileType"
    }

    companion object {
        private const val PORTRAIT_XLARGE = "portrait_xlarge"
        private const val DETAIL = "detail"
    }
}