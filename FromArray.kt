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

        val dataStream = Observable.fromArray(arrayOf(1, 2, 3, 4))

        val dataObserver = object : Observer<Array<Int>> {
            override fun onSubscribe(d: Disposable) {
                println("Subscribed to Observable")
            }

            override fun onNext(t: Array<Int>) {
                println("new data is received: ${Arrays.toString(t)}")

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
