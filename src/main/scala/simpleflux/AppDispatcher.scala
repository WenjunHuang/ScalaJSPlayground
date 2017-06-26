package simpleflux

import scala.collection.mutable

/**
  * Created by rick on 2017/6/26.
  */
object AppDispatcher {
    var callbacks = mutable.Map[String, (Action) => Unit]()

    def register(callback: (Action) => Unit): String = {
        val token = generateToken()
        callbacks += (token -> callback)

        token
    }

    def dispatch(action: Action): Unit = {
        beginDispatch(action)

        callbacks.foreach { key =>
            invokeCallback(key._1)
        }
    }

    private def beginDispatch(action: Action): Unit = {
        currentAction = action
    }

    private def invokeCallback(token: String): Unit = {
        if (!tempCalledLogs.contains(token)) {
            callbacks(token)(currentAction)
            tempCalledLogs += token
        }
    }

    private def endDispatch(): Unit = {
        tempCalledLogs.clear()
        currentAction = null
    }

    private def generateToken() = math.random().toString

    private var currentAction: Action = null
    private val tempCalledLogs = mutable.MutableList[String]()

}
