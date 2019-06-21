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

        val dataStream = Observable.interval(1, TimeUnit.SECONDS).takeWhile { value -> value <= 20 }

        val dataObserver = object : Observer<Long> {
            override fun onSubscribe(d: Disposable) {
                println("Observer subscribed to Observable")
            }

            override fun onNext(t: Long) {
                println("new data is received: $t")
            }

            override fun onComplete() {
                println("All data is received!")
            }

            override fun onError(e: Throwable) {
                println("A error is received ${e.message}")
            }
        }
        dataStream.subscribe(dataObserver)
    }
}
