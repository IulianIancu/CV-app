package com.challenge.mycvapp.ui

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import com.example.cvapp.data.Repository
import com.example.cvapp.data.model.CV
import com.example.cvapp.ui.MainViewModel
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import io.reactivex.plugins.RxJavaPlugins
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import java.util.concurrent.Executor

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var cvObserver: Observer<CV>

    @Mock
    lateinit var isLoadingObserver: Observer<Boolean>

    @Mock
    lateinit var isErrorObserver: Observer<Boolean>

    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var cv: CV

    lateinit var viewModel: MainViewModel

    companion object {
        @BeforeClass
        @JvmStatic
        fun setUpRxSchedulers() {
            val scheduler = object : Scheduler() {
                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker(Executor { it.run() }, false)
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { scheduler }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler }
        }
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        viewModel = MainViewModel(repository, CompositeDisposable())

        viewModel.getMyCvLiveData().observeForever(cvObserver)
        viewModel.getErrorLiveData().observeForever(isErrorObserver)
        viewModel.getLoadingLiveData().observeForever(isLoadingObserver)
    }


    @Test
    fun getMyCvThenSuccess() {

        Mockito.`when`(repository.getMyCV())
            .thenAnswer {
                return@thenAnswer Single.just(cv)
            }
        viewModel.getMyCV()

        verify(isErrorObserver,never()).onChanged(true)
        verify(cvObserver).onChanged(cv)
    }

    @Test
    fun getMyCvThenLoadingAndSuccess() {
        Mockito.`when`(repository.getMyCV())
            .thenAnswer {
                return@thenAnswer Single.just(cv)
            }

        viewModel.getMyCV()

        verify(isErrorObserver, never()).onChanged(true)
        verify(isLoadingObserver).onChanged(true)
        verify(cvObserver).onChanged(cv)
    }

    @Test
    fun getMyCvThenError() {
        Mockito.`when`(repository.getMyCV())
            .thenAnswer {
                return@thenAnswer Single.error<Throwable>(Throwable("Something went wrong"))
            }



        viewModel.getMyCV()

        verify(isErrorObserver).onChanged(true)

        verify(cvObserver, never()).onChanged(cv)

    }

    @Test
    fun getMyCvThenLoadingAndError() {
        Mockito.`when`(repository.getMyCV())
            .thenAnswer {
                return@thenAnswer Single.error<Throwable>(Throwable("Something went wrong"))
            }

        viewModel.getMyCV()

        verify(isLoadingObserver).onChanged(false)
        verify(isErrorObserver).onChanged(true)

    }
}