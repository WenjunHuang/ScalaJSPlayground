package counter.view

import counter.store.CounterStore
import japgolly.scalajs.react.vdom.html_<^._
import japgolly.scalajs.react.{Callback, ScalaComponent}

/**
  * Created by rick on 2017/6/26.
  */
object ControlPanel {

  case class State(sum:Int)

  val component = ScalaComponent.builder[Unit]("No args")
    .initialState(State(CounterStore.getState.foldLeft(0) { (accum, it) => accum + it._2 }))
    .render_S(state =>
      <.div(
        CounterContainer.component(CounterContainer.Props("First")),
        CounterContainer.component(CounterContainer.Props("Second")),
        CounterContainer.component(CounterContainer.Props("Third")),
        <.hr(),
        <.div(
          s"Total Count: ", state.sum
        )
      )
    )
    .componentDidMount { mount =>
      Callback {
        val callback = mount.modState {_ =>
          State(CounterStore.getState.foldLeft(0) { (accum, it) => accum + it._2 })
        }
        CounterStore.addChangeListener { () =>
//          modCb.runNow()
          callback.runNow()
        }
      }
    }
    .build
}
