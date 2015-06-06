package com.github.rexyotta.gradle_vertx_plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CreateTask extends DefaultTask{
  CreateTask() {
    setGroup(Constants.TASK_GROUP_NAME)
    setDescription('Create the Vert.x project layout.')
  }

  @TaskAction
  def create(){
    def File baseDir = getProject().projectDir
    println "************** $baseDir"
  }

}
