package com.example.reddish;

pipeline {
	agent any

	tools {
		maven 'Maven-3.9'
		jdk 'JDK-17'
	}

	environment {
		MVN_CMD = "mvn -B -DskipTests=false"
	}

	stages {

		stage('Checkout') {
			steps {
				git branch: 'main',
						url: 'https://github.com/your-org/hotel-microservices.git'
			}
		}

		stage('Build All Services') {
			steps {
				sh "${MVN_CMD} clean install"
			}
		}

		stage('Test All Services') {
			steps {
				sh "${MVN_CMD} test"
			}
		}

		stage('Package JAR Files') {
			steps {
				sh "${MVN_CMD} package"
			}
		}

		stage('Archive Artifacts') {
			steps {
				archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
			}
		}
	}

	post {
		success {
			echo "Hotel Microservices build completed successfully!"
		}
		failure {
			echo "Hotel Microservices build failed!"
		}
	}
}

