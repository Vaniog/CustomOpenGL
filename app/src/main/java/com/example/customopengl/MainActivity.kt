package com.example.customopengl

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.tanh

class SomeSpace : Space() {
    private var t = 0
    fun cube(a_ : Double, color : Int) {
        val a = a_ / 2
        square(-a, a, a, a, a, a, a, a, -a, -a, a, -a, color)
        square(a, a, a, -a, a, a, -a, -a, a, a, -a, a, color)
        square(a, -a, a, -a, -a, a, -a, -a, -a, a, -a, -a, color)
        square(-a, a, -a, a, a, -a, a, -a, -a, -a, -a, -a, color)
        square(-a, a, a, -a, a, -a, -a, -a, -a, -a, -a, a, color)
        square(a, a, -a, a, a, a, a, -a, a, a, -a, -a, color)
    }

    fun cubeOld(a_ : Double) {
        val a = a_ / 2
        for (i in 0..3) {
            triangle(a, a, a, a, a, -a, -a, a, -a, Color.BLUE)
            triangle(a, a, a, -a, a, -a, -a, a, a, Color.BLUE)
            rotateX(PI / 2.0)
        }

        for (i in 0..1) {
            triangle(a, a, a, a, -a, a, a, -a, -a, Color.BLUE)
            triangle(a, a, a, a, -a, -a, a, a, -a, Color.BLUE)
            rotateZ(PI)
        }
    }

    override fun onFrame() {
        t++
        translate(0.0, 0.0, 8.0)
        rotateX(-PI / 4.0)
        zoom(0.1, 0.1, 0.1)

        zoom(0.65, 0.65, 0.65)

        rotateX(cos(t * 0.03))
        rotateY(cos(t * 0.03))
        rotateZ(cos(t * 0.03))
        translate(0.0, -5.0, 0.0)
        rotateY(t * 0.02)


        pushMatrix()
        rotateZ(3 * PI / 4)
        rotateX(-cos(t * 0.05) * 1.5)
        for (i in 0..9){
            cube(1.0, Color.BLUE)
            translate(0.0, 1.0, 0.0)
            rotateZ(  PI / 40)
            rotateX(cos(t * 0.08) * 0.13)
        }
        popMatrix()

        pushMatrix()
        rotateZ(-3 * PI / 4)
        rotateX(cos(t * 0.05) * 1.5)
        for (i in 0..9){
            cube(1.0, Color.BLUE)
            translate(0.0, 1.0, 0.0)
            rotateZ(  -PI / 40)
            rotateX(-cos(t * 0.08) * 0.13)
        }
        popMatrix()

        for (i in 0..9){
            cube(1.0, Color.BLUE)
            translate(0.0, 1.0, 0.0)
            rotateX(cos(t * 0.05) * 0.05)
            rotateY(cos(t * 0.05) * 0.05)
            rotateZ(cos(t * 0.05) * 0.05)
        }


        pushMatrix()
        rotateZ(3 * PI / 4)
        rotateX(t * 0.03)
        for (i in 0..9){
            cube(1.0, Color.BLUE)
            translate(0.0, 1.0, 0.0)
            rotateZ(  PI / 40 + cos(t * 0.05) * 0.08)
        }
        popMatrix()

        pushMatrix()
        rotateZ(-3 * PI / 4)
        rotateX(t * 0.03 + PI)
        for (i in 0..9){
            cube(1.0, Color.BLUE)
            translate(0.0, 1.0, 0.0)
            rotateZ(  PI / -40 - cos(t * 0.05) * 0.08)
        }
        popMatrix()


        for (i in 0..1){
            cube(1.0, Color.BLUE)
            translate(0.0, 1.0, 0.0)
            rotateX(cos(t * 0.05) * 0.1)
            rotateY(cos(t * 0.05) * 0.1)
            rotateZ(cos(t * 0.05) * 0.1)
        }

        translate(0.0, 2.0, 0.0)
        cube(5.0, Color.BLUE)

        pushMatrix()
        translate(1.7, 1.7, -3.0)
        cube(1.5 * abs(cos(t * 0.09)), Color.WHITE)
        translate(0.0, 0.0, -0.5 * 1.5 * abs(cos(t * 0.09)))
        cube(0.5, Color.BLACK)
        popMatrix()

        pushMatrix()
        translate(-1.7, 1.7, -3.0)
        cube(1.5 * abs(cos(t * 0.09)), Color.WHITE)
        translate(0.0, 0.0, -0.5 * abs(cos(t * 0.09)) * 1.5)
        cube(0.5, Color.BLACK)
        popMatrix()

        translate(0.0, -1.0, -3.0)
        zoom(2.0 + cos(t * 0.09) * 1.5, 2.0 + cos(t * 0.07) * 1.3, 1.0)
        cube(1.0, Color.RED)

    }
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mySurfaceView = MySurfaceView(this, SomeSpace())

        setContentView(mySurfaceView)
    }
}
