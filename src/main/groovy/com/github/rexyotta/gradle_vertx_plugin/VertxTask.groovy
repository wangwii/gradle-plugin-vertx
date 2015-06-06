package com.github.rexyotta.gradle_vertx_plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class VertxTask extends DefaultTask{

  VertxTask() {
    setGroup(Constants.TASK_GROUP_NAME);
    setDescription('Display the Vert.x environment.')
  }

  @TaskAction
  def vertx(){
    //TODO: refactor to use other way: for example use vert.x jar library.

    println '==================================='
    println "Vertx Version: ${project.property('vertx_version')}"
    println '==================================='
  }
}
