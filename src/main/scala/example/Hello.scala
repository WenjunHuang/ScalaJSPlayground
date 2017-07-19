package example

import org.scalajs.dom
import org.scalajs.dom._

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import scala.util.Success

@JSExportTopLevel("Hello")
object Hello extends JSApp {

  //  override def main(): Unit = {
  //    val component = Provider.component
  //    component(Provider.Props(ControlPanel.component())).renderIntoDOM(document.getElementById("app"))
  //  }
  override def main(): Unit = {
    import dom.ext._

    import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
    val url = "https://api.douban.com/v2/book/1220562"
    val target = document.querySelector("#app")
    Ajax.get(url,headers = Map()).onComplete {
      case Success(xhr) =>
        val pre = document.createElement("pre")
        pre.textContent = xhr.responseText
        target.appendChild(pre)
    }
  }

  @JSExport
  def main(canvas: html.Canvas): Unit = {
  }

}

