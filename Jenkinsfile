pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/rohitambawade09/CICD_Project.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh '''
                docker build -t rohitambawade181/cicdproject:${BUILD_NUMBER} .
                '''
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u rohitambawade181 -p ${Dockerpwd}"
                }
            }
        }

        stage('Docker Push') {
            steps {
                sh '''
                docker push rohitambawade181/cicdproject:${BUILD_NUMBER}
                '''
            }
        }

        stage('Deploy on EC2') {
            steps {
                sh 'docker run -d -p 8081:8080 rohitambawade181/cicdproject:${BUILD_NUMBER}'
            }
        }
        
        stage('Archving') {
			steps {
				archiveArtifacts '**/target/*.jar'
			}
		}
    }

    post {
        success {
            echo "Application deployed successfully on EC2!"
        }
        failure {
            echo "Build or deployment failed"
        }
    }
}
