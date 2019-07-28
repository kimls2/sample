package app.sample.dtos.comic

data class ComicResultDto(
        val code: Int,
        val status: String,
        val data: ComicDataDto
)