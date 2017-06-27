package counter.store

import simpleflux.EventEmmiter

/**
  * Created by rick on 2017/6/26.
  */
object SummaryStore extends EventEmmiter {
  val SummaryChangedEvent = "SummaryChangedEvent"
  var DispatchToken: String = null

  def getSummary(): Int = CounterStore.counterValues.values.sum

  def summaryChanged(): Unit = {
    emit(SummaryChangedEvent)
  }

  def addChangeListener(callback: () => Unit): Unit = {
    on(SummaryChangedEvent, callback)
  }

  def removeChangeListener(callback: () => Unit): Unit = {
    off(SummaryChangedEvent, callback)
  }

}
