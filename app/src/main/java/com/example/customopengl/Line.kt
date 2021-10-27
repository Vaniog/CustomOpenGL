package com.example.customopengl

import android.graphics.Color
import kotlin.math.abs
import kotlin.math.sqrt


/*open class Line {
    var point1 = Point(0.0, 0.0, 0.0)
    var point2 = Point(0.0, 0.0, 0.0)

    constructor(point1 : Point, point2 : Point){
        this.point1 = point1
        this.point2 = point2
    }

    constructor(point : Point, vector: Vector){
        this.point1 = point
        point2 = point1 + vector
    }


    fun transform(matrix: MatrixMath) {
        point1 *= matrix
        point2 *= matrix
    }
}


fun intersection(line : Line, point: Point, vector: Vector) : Pair<Double, Point> {
    val plane = Plane(line.point1, Vector(line.point1, line.point2), vector)
    var distance = abs(plane.a * point.x + plane.b + point.y + plane.c * point.z + plane.d) /
            sqrt(plane.a * plane.a + plane.b * plane.b + plane.c * plane.c)

    return Pair(distance, point)
}



class DrawableLine (var point1 : Point, var point2: Point,
                    var color : Int,
                    val thickness : Double) : DrawableObject(){
    private val line = Line(point1, point2)

    override fun transform(matrix: MatrixMath) {
        line.transform(matrix)
    }


    override fun collision(vector: Vector) : Pair<Boolean, Point> {
        val inters = intersection(line, Point(0.0, 0.0, 0.0), vector)
        if (inters.first > thickness)
            return Pair(false, Point(0.0, 0.0, 0.0))
        inters.second.color = color
        return Pair(true, inters.second)
    }
}*/
