package com.example.customopengl


class Plane {
    var a = 0.0
    var b = 0.0
    var c = 0.0
    var d = 0.0

    constructor(a : Double, b : Double, c : Double, d : Double){
        this.a = a
        this.b = b
        this.c = c
        this.d = d
    }

    constructor(point: Point, vector1 : Vector, vector2 : Vector){
        convertFromMatrix(MatrixMath(arrayOf(
            arrayOf(-point.x, -point.y, -point.z),
            arrayOf(vector1.x, vector1.y, vector1.z),
            arrayOf(vector2.x, vector2.y, vector2.z)
        )))
    }

    fun convertFromMatrix(matrix: MatrixMath){
        val detA = (matrix.algComp(0, 0)).det2x2()
        val detB = (matrix.algComp(1, 0)).det2x2()
        val detC = (matrix.algComp(2, 0)).det2x2()
        a = detA
        b = -detB
        c = detC
        d = matrix.array[0][0] * detA - matrix.array[0][1] * detB + matrix.array[0][2] * detC
    }
}