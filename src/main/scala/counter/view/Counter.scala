package counter.view

import counter.store.{CounterStore, CounterStoreActions}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

/**
  * Created by rick on 2017/6/26.
  */
object Counter {

  case class Props(caption: String, onIncrement: () => Unit, onDecrement: () => Unit, value: Int)

  case class State(caption: String, counter: Int)

  val component = ScalaComponent.builder[Props]("Counter")
    .initialStateFromProps { props =>
      new State(props.caption, CounterStore.getState(props.caption))
    }
    .render_P { props =>
      <.div(
        ^.`class` := "chap02-btn",
        <.button(
          ^.onClick --> Callback {
            props.onIncrement()
          },
          "+"
        ),
        <.button(
          ^.`class` := "chap02-btn",
          ^.onClick --> Callback {
            props.onDecrement()
          },
          "-"
        ),
        <.span(
          s"${props.caption} count: ${props.value}"
        )
      )
    }
    .componentDidMount { mount =>
      Callback {
        val modCb = mount.modState { state =>
          state.copy(counter = CounterStore.getState(state.caption))
        }
        CounterStore.addChangeListener { () =>
          modCb.runNow()
        }
      }
    }
    .build

  def onButtonClicked: Callback = Callback.alert("The button was pressed!")
}

object CounterContainer {

  case class Props(caption: String)

  val component = ScalaComponent.builder[Props]("CounterContainer")
    .render_P { props =>
      Counter.component(new Counter.Props(props.caption, onIncrement(props), onDecrement(props), CounterStore.getState(props.caption)))
    }
    .build

  def onIncrement(props: Props)(): Unit = {
    println("onIncrement")
    CounterStoreActions.increment(props.caption)
  }

  def onDecrement(props: Props)(): Unit = {
    CounterStoreActions.decrement(props.caption)
  }

}
