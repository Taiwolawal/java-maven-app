
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn package'  
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                        sh 'docker build -t wizhubdocker8s/java-maven-app:jma-1.2 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push wizhubdocker8s/java-maven-app:jma-1.2'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying the application"
                }
            }
        }
    }   
}