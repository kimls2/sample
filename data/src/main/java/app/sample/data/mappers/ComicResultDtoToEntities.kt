package app.sample.data.mappers

import app.sample.data.entities.Comic
import app.sample.dtos.comic.ComicResultDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicResultDtoToEntities @Inject constructor() : Mapper<ComicResultDto, List<Comic>> {
    override suspend fun map(from: ComicResultDto): List<Comic> {
        return from.data.results.map {
            Comic(
                    id = 0,
                    marvelComicId = it.id,
                    title = it.title,
                    description = it.description ?: "",
                    thumbnailPath = it.thumbnail.path,
                    thumbnailFileType = it.thumbnail.extension
            )
        }
    }
}