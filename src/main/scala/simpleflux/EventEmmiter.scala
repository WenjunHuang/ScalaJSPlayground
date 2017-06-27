package simpleflux

import scala.collection.mutable

/**
  * Created by rick on 2017/6/26.
  */
abstract class EventEmmiter {
    val callbacks: mutable.Map[String, List[() => Unit]] = mutable.Map()

    def on(event: String, callback: () => Unit): EventEmmiter = {
        callbacks.get(event) match {
            case Some(list) =>
                callbacks.put(event, list :+ callback)
            case None =>
                callbacks.put(event, List(callback))
        }
        this
    }

    def off(event: String, callback: () => Unit): EventEmmiter = {
        callbacks.get(event) match {
            case Some(list) =>
                callbacks.put(event, list.filter(_ != callback))
            case None =>
        }
        this
    }

    def once(event: String, callback: () => Unit): EventEmmiter = {
        var wrapper: () => Unit = null
        wrapper = () => {
            callback()
            off(event, wrapper)
        }
        on(event, wrapper)

        this
    }

    def emit(event: String): Unit = {
        println(s"emit $event")
        for {
            list <- callbacks.get(event)
            callback <- list
        } callback()
    }

}
