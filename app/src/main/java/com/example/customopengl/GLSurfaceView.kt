package com.example.customopengl

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.os.Build
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.annotation.RequiresApi

class GLSurfaceView (context: Context, space : Space) : SurfaceView(context), SurfaceHolder.Callback {

    private var surfaceThread = SurfaceDrawingThread(holder, space)

    init{
        holder.addCallback(this)
    }
    override fun surfaceCreated(holder: SurfaceHolder) {
        surfaceThread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        if (!surfaceThread.isAlive)
            surfaceThread.start()
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
    }
}

class SurfaceDrawingThread(private val surfaceHolder: SurfaceHolder, private val space : Space) : Thread(){
    private var go = true

    fun kill(){
        go = false
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun run() {
        go = true
        while(go) {
            doFrame()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun doFrame(){

        val canvas : Canvas = surfaceHolder.lockCanvas() ?: return
        canvas.drawColor(Color.BLACK)
        space.fillCanvas(canvas)
        surfaceHolder.unlockCanvasAndPost(canvas)
    }

}