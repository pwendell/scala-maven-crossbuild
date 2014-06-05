package main.scala

import breeze.linalg._

object Foo {
  def main(args: Array[String]) = {
    val x = DenseVector.zeros[Double](5)
    println(x)
  }
}

