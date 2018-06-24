package scalatags.mrx

import mhtml._
import scalatags.mrx.all._
import org.scalatest.{Matchers, WordSpec}
import scalatags.JsDom.all._

class MRxAttrSpec extends WordSpec with Matchers {
  "a node" should {
    "update attribute contents" when {
      "Var" in {
        val c = Var(10)
        val node = div(widthA := c).render

        node getAttribute "width" should be ("10")

        c := 20

        node getAttribute "width" should be ("20")
      }

      "Rx" in {
        val c = Var(10)
        val rxMap: Rx[String] = c.map(_ + "px")
        val node = div(widthA := rxMap).render

        node getAttribute "width" should be ("10px")

        c := 20

        node getAttribute "width" should be ("20px")
      }

      "Map" in {
        val c = Var(10)
        val rxMap = c.map(_ + "px")

        val node = div(widthA := rxMap).render

        node getAttribute "width" should be ("10px")

        c := 20

        node getAttribute "width" should be ("20px")
      }

      "Inline map" in {
        val c = Var(10)
        val node = div(widthA := c.map(_ + "px")).render

        node getAttribute "width" should be ("10px")

        c := 20

        node getAttribute "width" should be ("20px")
      }
    }
  }
}
