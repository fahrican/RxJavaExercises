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

        val dataStream = Observable.just("Test1", "Test2", "Test3")
        val dataStream2 = Observable.just("Test7", "Test8", "Test9")
        val dataStream3 = dataStream2.mergeWith(dataStream)

        val dataObserver = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                println("Observer subscribed to Observable")
            }

            override fun onNext(t: String) {
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
