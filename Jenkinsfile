pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                echo 'Code is already cloned by Jenkins'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t my-python-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                sh 'docker run my-python-app'
            }
        }
    }
}
