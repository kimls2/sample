package app.sample.dtos.comic

data class ComicDto(
        val id: Int,
        val title: String,
        val description: String? = null,
        val thumbnail: Thumbnail
)