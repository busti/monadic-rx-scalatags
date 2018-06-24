package scalatags.mrx

import mhtml._
import org.scalajs.dom
import org.scalajs.dom.Element
import scalatags.JsDom.all._

class nodes {
  implicit class mRxStringFrag(rx: Rx[String]) extends Frag {
    def render: dom.Text = {
      val node = dom.document.createTextNode(rx.)
      rx.impure.run(node.replaceData(0, node.length, _))
      node
    }

    def applyTo(t: Element) = {
      t.appendChild(render)
    }
  }
}
