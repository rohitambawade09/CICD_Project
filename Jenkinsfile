pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/rohitambawade09/CICD_Project.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t springboot-cicd .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop springboot-cicd || true
                docker rm springboot-cicd || true
                docker run -d -p 8080:8080 --name springboot-cicd springboot-cicd
                '''
            }
        }
    }
}
