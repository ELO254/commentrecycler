package com.example.commentslogic

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var list = listOf(Comment("food", mutableListOf()),Comment("desert", mutableListOf()))

        var recy:RecyclerView = findViewById(R.id.commentrecy)
        recy.layoutManager = LinearLayoutManager(this)

        var adapter = commentAdapter(list){

            setDialogAlert(it)

        }

        recy.adapter = adapter
    }

    fun setDialogAlert(comment: Comment){

        var edittext = EditText(this)
        AlertDialog.Builder(this)
            .setView(edittext)
            .setTitle(comment.name)
            .setMessage(comment.comments.joinToString("\n"))
            .setPositiveButton("ok"){ alert, click ->

                var newcomment = edittext.text.toString()

                comment.comments = comment.comments.toMutableList().apply { add(newcomment) }

                alert.dismiss()

            }
            .show()


    }
}