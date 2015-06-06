package com.github.rexyotta.gradle_vertx_plugin

import org.gradle.api.Project
import org.gradle.api.invocation.Gradle

class Plugin implements org.gradle.api.Plugin<Project> {

  void apply(Project project) {
    def Conf conf = new Conf()
    syncConfiguration(project, conf)

    createExtension(project)
    buildDependencies(project, conf)
    createTasks(project)
  }

  private static void syncConfiguration(Project project, Conf conf) {
    conf.each { key, value ->
      if (project.hasProperty(key)) {
        conf[key] = project.properties[key]
      }else{
        //TODO:..
      }
    }
  }

  private static void createTasks(Project project) {
    project.tasks.create(Constants.VERTX_TASK_NAME, VertxTask.class)
    project.tasks.create(Constants.VERTX_TASK_NAME, CreateTask.class)
  }

  private static void createExtension(Project project) {
    project.extensions.create('vertx', PluginExtension)
  }

  private static void buildDependencies(Project project, Conf conf) {
    project.configurations {
      provided
      testCompile.extendsFrom provided
    }

    def items = [
      "io.vertx:vertx-core:${conf.vertx_version}",
      "io.vertx:vertx-platform:${conf.vertx_version}"
    ]

    project.dependencies { items.each { provided it } }
  }
}
