package app.sample.dtos.comic

data class ComicDataDto(
        val offset: Int,
        val limit: Int,
        val total: Int,
        val count: Int,
        val results: List<ComicDto>
)