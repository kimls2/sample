package app.sample.data.repositories.comic

import app.sample.data.entities.Comic
import app.sample.data.entities.Result
import app.sample.data.mappers.ComicResultDtoToEntities
import app.sample.data.mappers.toLambda
import app.sample.extensions.toResult
import app.sample.remote.services.ComicService
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Named

class RemoteComicDataSource @Inject constructor(
        @Named("apiPublicKey") private val publicKey: String,
        @Named("apiPrivateKey") private val privateKey: String,
        private val comicService: ComicService,
        private val mapper: ComicResultDtoToEntities
) {
    suspend fun getComics(): Result<List<Comic>> {
        val hash = getHash(publicKey, privateKey)
        return comicService.getComics(
                timeStamp = hash.first,
                md5Hash = hash.second
        ).toResult(mapper.toLambda())
    }

    private fun getHash(publicKey: String, privateKey: String): Pair<String, String> {
        val timeStamp = System.currentTimeMillis().toString()
        val combination = timeStamp + privateKey + publicKey
        val messageDigest = MessageDigest.getInstance("MD5")
        messageDigest.update(combination.toByteArray(), 0, combination.length)
        val md5 = BigInteger(1, messageDigest.digest()).toString(16)
        return Pair(timeStamp, md5)
    }
}