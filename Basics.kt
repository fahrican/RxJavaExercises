package com.example.android.rxjavatry

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Observable.fromArray("Ted", "Ryan", "Billy")
            .subscribeOn(Schedulers.newThread()) // creates for operation a new thread
            .filter { item -> item == "Ted" } // filters the item in the list
            .observeOn(AndroidSchedulers.mainThread()) //sets the observer on the main/UI thread
            .subscribe { onNext -> main_text_view.text = onNext } // access the text view in the main/UI thread
    }
}
