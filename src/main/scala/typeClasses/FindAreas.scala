package typeClasses

import scala.language.postfixOps

object FindAreas extends App {

  private case class Circle(radius: Double)

  private case class Rectangle(side: Double)

  trait Area[T] {
    def findArea(shape: T): Double
  }

  private object areaInstances {
    implicit val findAreaOfCircle: Area[Circle] = new Area[Circle] {
      override def findArea(shape: Circle): Double = shape.radius * shape.radius * 3.14
    }

    implicit val findAreaOfRectangle: Area[Rectangle] = new Area[Rectangle] {
      override def findArea(shape: Rectangle): Double = shape.side * shape.side
    }
  }


    private object calculation {
      def calculateArea[A](value: A)(implicit s: Area[A]): Double = {
        s.findArea(value)
      }
    }

    import areaInstances._
    println("Area of Circle: " + calculation.calculateArea(Circle(2.5)))
    println("Area of Rectangle: " + calculation.calculateArea(Rectangle(2)))

    implicit class FindingArea[A](a: A) {
      def areaOf(implicit shape: Area[A]): Double = shape.findArea(a)
    }

    println("Area of circle with interface object : " + Circle(2.5).areaOf)
  }

