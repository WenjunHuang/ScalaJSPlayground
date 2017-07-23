package todos.todolist

package object actions {
  val AddTodo = 'AddTodo
  val ToggleTodo = 'ToggleTodo
  val RemoveTodo = 'RemoveTodo
  var sequence = 0

  def nextTodoId = {
    sequence = sequence + 1
    sequence
  }
}
