def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t wizhubdocker8s/java-maven-app:jma-1.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push wizhubdocker8s/java-maven-app:jma-1.2'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this