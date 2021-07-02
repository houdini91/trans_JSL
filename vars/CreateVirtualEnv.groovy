#!groovy
import jenkins.pipeline.lib.Constants

def createPython3VirtualEnv(String name) {
    sh "python3 -m venv $name" 
}

def createVirtualEnv(String name) {
    sh "virutalenv ${name}"
}

def call(String name="venv") {
    createPython3VirtualEnv(name)
}