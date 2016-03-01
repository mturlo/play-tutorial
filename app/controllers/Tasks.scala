package controllers

import model.Task
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._

/**
  * Created by mactur on 01/03/16.
  */
class Tasks extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  def listTasks = Action {
    val sampleTasks = List(
      Task(1, "Task one"),
      Task(2, "Task two")
    )
    Ok(views.html.tasks(sampleTasks, taskForm))
  }

  def createTask = TODO

  def deleteTask(id: Long) = TODO

}
