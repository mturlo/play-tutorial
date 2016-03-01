package controllers

import model.Task
import play.api.data.Forms._
import play.api.data._
import play.api.mvc._
import play.api.Play.current
import play.api.i18n.Messages.Implicits._

import scala.collection.mutable
import scala.util.Random

/**
  * Created by mactur on 01/03/16.
  */
class Tasks extends Controller {

  val taskForm = Form(
    "label" -> nonEmptyText
  )

  val sampleTasks = mutable.MutableList(
    Task(1, "Task one"),
    Task(2, "Task two")
  )

  def listTasks = Action {
    Ok(views.html.tasks(sampleTasks.toList, taskForm))
  }

  def createTask = Action {implicit request =>
    taskForm.bindFromRequest.fold(
      errors => BadRequest(views.html.tasks(sampleTasks.toList, errors)),
      label => {
        sampleTasks += Task(Random.nextInt(), label)
        Redirect(routes.Tasks.listTasks)
      }
    )
  }

  def deleteTask(id: Long) = TODO

}
