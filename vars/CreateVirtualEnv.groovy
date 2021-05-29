#!groovy
import jenkins.pipeline.lib.Constants

def createVirtualEnv(String name) {
    sh "virtualenv ${name}"
}

def call(String name= "venv") {
    createVirtualEnv(name)
}