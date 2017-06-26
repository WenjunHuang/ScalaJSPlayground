package counter.store

import CounterStoreActions
import simpleflux.EventEmmiter

import scala.collection.mutable

/**
  * Created by rick on 2017/6/26.
  */



object CounterStore extends EventEmmiter {
    val CounterChangedEvent = "CounterChangedEvent"
    var DispatchToken: String = null

    val counterValues = mutable.Map("First" -> 0, "Second" -> 10, "Third" -> 30)

    def addChangeListener(callback:()=>Unit): Unit = {
        on(CounterStore.CounterChangedEvent, callback)
    }

    def removeChangeListener(callback: ()=>Unit): Unit = {
        off(CounterStore.CounterChangedEvent, callback)
    }

    def incrementByOne(counterCaption: String): Unit = {
        for (value <- counterValues.get(counterCaption)){
            counterValues.put(counterCaption, value + 1)
            emit(CounterStore.CounterChangedEvent)
        }
    }

    def decrementByOne(counterCaption:String): Unit = {
        for (value <- counterValues.get(counterCaption)) {
            counterValues.put(counterCaption, value - 1)
            emit(CounterStore.CounterChangedEvent)
        }
    }
}
