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

        createZipWith().subscribe(
            { name -> println("value is $name") },
            { throwable -> println("There is an error in ${throwable.javaClass.simpleName}") }
        )
    }

    fun createZipWith(): Observable<String>{
        val dataStream = Observable.just("Marco", "Matthias", "Dominik", "Markus")
        val dataStream2 = Observable.just("Zema", "Muck", "Tanesic", "Lusar")
        return dataStream.zipWith(dataStream2, BiFunction { fistName: String, lastName: String ->
            "$fistName $lastName"
        })
    }
}
