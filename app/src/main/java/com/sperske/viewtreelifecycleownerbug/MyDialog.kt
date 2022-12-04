package com.sperske.viewtreelifecycleownerbug

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.ViewTreeLifecycleOwner

class MyDialog(context: Context, private val parent: ViewGroup): AppCompatDialog(context) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val view = LayoutInflater.from(context).inflate(R.layout.dialog_content, parent, false)
    setContentView(view)

    val button = findViewById<Button>(R.id.crash)
    button?.setOnClickListener {
      // setContentView above should have reached ComponentDialog to initialize the ViewTreeLifeCycleOwner
      ViewTreeLifecycleOwner.get(view)!!
    }
  }
}