package com.github.wangweixian.vertxplugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

import static org.junit.Assert.assertTrue

class VertxPluginTest extends GroovyTestCase {
  void testApply() {
    Project project = ProjectBuilder.builder().build()
    project.apply plugin: 'com.github.wangweixian.vert-x'

    assertTrue(project.tasks.size() > 0)
  }
}
