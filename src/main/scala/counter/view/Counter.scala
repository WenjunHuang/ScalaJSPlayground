package counter.view

import counter.store.{CounterStore, CounterStoreActions}
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

/**
  * Created by rick on 2017/6/26.
  */
object Counter {

  case class Props(caption: String)

  case class State(caption: String, counter: Int)

  val component = ScalaComponent.builder[Props]("Counter")
    .initialStateFromProps { props =>
      new State(props.caption, CounterStore.getState(props.caption))
    }
    .render_S { state =>
      <.div(
        ^.`class` := "chap02-btn",
        <.button(
          ^.onClick --> Callback {
            println("in callback")
            CounterStoreActions.increment(state.caption)
          },
          "+"
        ),
        <.button(
          ^.`class` := "chap02-btn",
          ^.onClick --> Callback {
            CounterStoreActions.decrement(state.caption)
          },
          "-"
        ),
        <.span(
          s"${state.caption} count: ${state.counter}"
        )
      )
    }
    .componentDidMount { mount =>
      Callback {
        val modCb = mount.modState{ state =>
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
