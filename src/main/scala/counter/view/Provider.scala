package counter.view

import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.VdomElement

/**
  * Created by rick on 2017/7/19.
  */
object Provider {
  case class Props(children: VdomElement)
  val component = ScalaComponent.builder[Props]("Provider")
      .render_P {props=>
        props.children
      }

    .build

}
