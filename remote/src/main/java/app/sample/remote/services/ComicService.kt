package app.sample.remote.services

import app.sample.dtos.comic.ComicResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicService {
    @GET("v1/public/comics")
    suspend fun getComics(
        @Query("hasDigitalIssue") hasDigitalIssue: Boolean = true,
        @Query("ts") timeStamp: String,
        @Query("hash") md5Hash: String,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 40
    ): Response<ComicResultDto>

    @GET("v1/public/comics/{comicId}")
    suspend fun getComicWithId(
        @Path("comicId") comicId: Int,
        @Query("apikey") apiKey: String,
        @Query("ts") timeStamp: String,
        @Query("hash") md5Hash: String
    ): ComicResultDto
}