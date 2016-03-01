package service

import javax.inject.Singleton

import model.Task

import scala.collection.mutable
import scala.util.Random

/**
  * Created by mactur on 01/03/16.
  */
@Singleton
class TaskService {

  private val sampleTasks = mutable.MutableList(
    Task(1, "Task one"),
    Task(2, "Task two")
  )

  def getAll: List[Task] = {
    sampleTasks.toList
  }

  def create(label: String): Task = {
    val newTask = Task(Random.nextInt(), label)
    sampleTasks += newTask
    newTask
  }

  def delete(id: Long): Unit = {
    ???
  }

}
