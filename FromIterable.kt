package com.example.rxjavamasterclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStream = Observable.fromIterable(mutableListOf(1, 2, 3, 4))

        val dataObserver = object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                println("Subscribed to Observable")
            }

            override fun onNext(t: Int) {
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
