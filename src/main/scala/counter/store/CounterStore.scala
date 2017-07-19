package counter.store

import simpleflux.{Action, EventEmmiter}

/**
  * Created by rick on 2017/6/26.
  */


object CounterStore extends EventEmmiter {
  val CounterChangedEvent = "CounterChangedEvent"
  var DispatchToken: String = null

  type State = Map[String, Int]
  var state = Map("First" -> 100, "Second" -> 200, "Third" -> 300)

  def reducer(store: State, action: Action): State = action.actionType match {
    case CounterStoreActions.Increment =>
      action.counterCaption match {
        case "First" =>
          store + ("First" -> (store("First") + 1))
        case "Second" =>
          store + ("Second" -> (store("Second") + 1))
        case "Third" =>
          store + ("Third" -> (store("Third") + 1))
        case _ =>
          store
      }
    case CounterStoreActions.Decrement =>
      action.counterCaption match {
        case "First" =>
          store + ("First" -> (store("First") - 1))
        case "Second" =>
          store + ("Second" -> (store("Second") - 1))
        case "Third" =>
          store + ("Third" -> (store("Third") - 1))
        case _=>
          store
      }
    case _ =>
      store
  }

  def getState = state

  def addChangeListener(callback: () => Unit): Unit = {
    on(CounterStore.CounterChangedEvent, callback)
  }

  def removeChangeListener(callback: () => Unit): Unit = {
    off(CounterStore.CounterChangedEvent, callback)
  }

  def dispatch(action: Action): Unit = {
    val oldState = state
    state = reducer(state, action)
    if (oldState != state)
      emit(CounterStore.CounterChangedEvent)
  }
}
