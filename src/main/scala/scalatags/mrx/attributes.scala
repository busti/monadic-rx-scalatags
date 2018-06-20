package scalatags.mrx

import mhtml._
import org.scalajs.dom.Element
import scalatags.JsDom.all._

trait MRxAttrInstances {
  class MRxAttrValue[T, F <: Rx[T]](implicit av: AttrValue[T]) extends AttrValue[F] {
    override def apply(t: Element, a: Attr, v: F) {
      v.impure.run(av(t, a, _))
    }
  }

  implicit def mRxAttrValue[T: AttrValue]: AttrValue[Rx[T]] = new MRxAttrValue[T, Rx[T]]
  implicit def mVarAttrValue[T: AttrValue]: AttrValue[Var[T]] = new MRxAttrValue[T, Var[T]]
}
