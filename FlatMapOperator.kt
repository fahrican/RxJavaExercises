package com.example.rxjavamasterclass

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val dataStream = Observable.just("x1000", "x861hk", "yt88")
            .flatMap { name -> getName(name) }

        dataStream.subscribe(
            { name -> println("value is $name") },
            { throwable -> println("There is an error in ${throwable.javaClass.simpleName}") }
        )
    }

    fun getName(name: String): Observable<String>{
        val names = arrayOf("Mislav", "Vjeko", "Voltis")
        val random = Random().nextInt(3)
        return Observable.just(names[random])
    }
}
