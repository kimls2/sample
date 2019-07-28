package app.sample.data.mappers

interface Mapper<F, T> {
    suspend fun map(from: F): T
}

fun <F, T> Mapper<F, T>.toLambda(): suspend (F) -> T {
    return { map(it) }
}