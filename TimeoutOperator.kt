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

        createTimeout("Anel").subscribe(
            { name -> println("Hello $name !!!") },
            { throwable -> println("There is an error in ${throwable.javaClass.simpleName}") }
        )
    }

    private fun createTimeout(name: String): Observable<String> {
        return Observable.fromCallable {
            if (name.equals("Anel")) {
                Thread.sleep(150)
            }
            name
        }.timeout(100, TimeUnit.MILLISECONDS)
    }
}
