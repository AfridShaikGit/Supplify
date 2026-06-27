pipeline {
    agent any

    environment {
        DOCKER_USERNAME = "afridshaik3838"
        BACKEND_IMAGE = "afridshaik3838/supplify-backend:v3"
        FRONTEND_IMAGE = "afridshaik3838/supplify-frontend:v3"
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Verify Workspace') {
            steps {
                sh 'pwd'
                sh 'ls -la'
            }
        }

        stage('Build Backend Jar') {
            steps {
                sh '''
                    chmod +x mvnw
                    ./mvnw clean package -DskipTests
                '''
            }
        }

        stage('Verify Jar') {
            steps {
                sh '''
                    echo "Checking target folder..."
                    ls -la target
                '''
            }
        }

        stage('Build Backend Docker Image') {
            steps {
                sh '''
                    docker build -t ${BACKEND_IMAGE} .
                '''
            }
        }

        stage('Build Frontend Docker Image') {
            steps {
                sh '''
                    docker build \
                    -t ${FRONTEND_IMAGE} \
                    ./src/main/webapp/Supplify
                '''
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([
                    usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS'
                    )
                ]) {
                    sh '''
                        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
                    '''
                }
            }
        }

        stage('Push Backend Image') {
            steps {
                sh '''
                    docker push ${BACKEND_IMAGE}
                '''
            }
        }

        stage('Push Frontend Image') {
            steps {
                sh '''
                    docker push ${FRONTEND_IMAGE}
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }

        always {
            sh 'docker logout || true'
        }
    }
}