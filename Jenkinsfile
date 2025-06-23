pipeline {
    agent any
    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn -s .mvn/settings.xml test'
            }
        }
    }
}
