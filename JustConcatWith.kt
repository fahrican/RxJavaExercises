package com.example.rxjavamasterclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStream = Observable.just(1, 2, 3, 4)
        val dataStream2 = Observable.just(6, 7, 8)
        /*
        * The Concat operator concatenates the output of multiple Observables so that t
        * hey act like a single Observable, with all of the items emitted 
        * by the first Observable being emitted before any of the items emitted 
        * by the second Observable (and so forth, if there are more than two).
        * */
        val dataStream3 = dataStream2.concatWith(dataStream)

        val dataObserver = object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("Observer subscribed to Observable")
            }

            override fun onNext(t: Int) {
                println("Item received $t")
            }

            override fun onComplete() {
                println("All data is received!")
            }

            override fun onError(e: Throwable) {
                println("A error is received ${e.message}")
            }
        }
        dataStream3.subscribe(dataObserver)
    }
}
