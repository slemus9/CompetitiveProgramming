package algorithms.geometry.basicGeometry

import kotlin.math.acos
import kotlin.math.sqrt


class Vector(val xs: List<Double>){

    val dim = xs.size

    infix fun at(i: Int) = xs[i]

    infix fun sum(u: Vector): Vector = Vector(xs.zip(u.xs).map { (x1, x2) -> x1 + x2 })

    infix fun mult(s: Double): Vector = Vector(xs.map { it*s })

    fun neg(): Vector = this.mult(-1.0)

    infix fun dot(u: Vector): Double = xs.zip(u.xs).map { (x1, x2) -> x1 * x2 }.sum()

    fun norm(): Double = this dot this

    infix fun proj(u: Vector): Double = (this dot u) / sqrt(u.norm())

    infix fun angle(u: Vector): Double = acos( (this dot u)  / sqrt(this.norm()) / sqrt(u.norm()) )

    // Only for 3-D vectors
    infix fun cross3D(u: Vector): Vector = Vector(listOf(
            this.at(1) * u.at(2) - this.at(2) * u.at(1),
            this.at(2) * u.at(0) - this.at(0) * u.at(2),
            this.at(0) * u.at(1) - this.at(1) * u.at(0)
    ))

    fun triple(u: Vector, w: Vector): Double = this dot (u cross3D w)

    // Only for 2-D vectors
    infix fun cross2D(u: Vector): Double = this.at(0) * u.at(1) - this.at(1) * u.at(0)

}