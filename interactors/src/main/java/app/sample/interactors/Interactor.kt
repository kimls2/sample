package app.sample.interactors

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface Interactor<in P> {
    val dispatcher: CoroutineDispatcher
    suspend operator fun invoke(params: P)
}

abstract class SuspendingWorkInteractor<P : Any, T> : Interactor<P> {
    private val subject: Subject<T> = BehaviorSubject.create()

    override suspend operator fun invoke(params: P) = subject.onNext(doWork(params))

    abstract suspend fun doWork(params: P): T

    fun observe(): Observable<T> = subject
}

abstract class SubjectInteractor<P : Any, T> {
    private val subject: Subject<P> = BehaviorSubject.create()
    private val observable = subject.switchMap(::createObservable)

    operator fun invoke(params: P) = subject.onNext(params)

    protected abstract fun createObservable(params: P): Observable<T>

    fun observe(): Observable<T> = observable
}

fun <P> CoroutineScope.launchInteractor(interactor: Interactor<P>, param: P): Job {
    return launch(context = interactor.dispatcher, block = { interactor(param) })
}

suspend fun <P> Interactor<P>.execute(param: P) = withContext(context = dispatcher) {
    invoke(param)
}