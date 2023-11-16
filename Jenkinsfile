pipeline {
    agent any

    environment {
        JDK_VERSION = 'JDK 17'
        gradle 'Gradle 8.4'
    }

    stages {
        stage('Build'){
            steps {
                script {
                    // Install and configure the JDK using the 'tools' step
                    def jdkInstallation = tool name: "${env.JDK_VERSION}", type: 'jdk'
                    env.JAVA_HOME = "${jdkInstallation}"
                    env.PATH = "${jdkInstallation}/bin:${env.PATH}"
                    sh 'java -version'
                    sh 'javac -version'
                }
                echo 'Building Commission Project'
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                sh './gradlew test'
            }
            post {
                always {
                    junit "build/test-results/test/**/*.xml"
                }
            }
        }
    }
}