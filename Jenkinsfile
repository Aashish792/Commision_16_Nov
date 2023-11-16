pipeline {
    agent any

    environment {
        // Define the JDK tool name configured in Jenkins
        JDK_VERSION = 'JDK 17'
        // Define the Gradle tool name configured in Jenkins
        GRADLE_VERSION = 'Gradle 8.4'
    }

    stages {
        stage('Build'){
            steps {
                // Install and configure the JDK using the 'tools' step
                script {
                    def jdkInstallation = tool name: "${env.JDK_VERSION}", type: 'jdk'
                    env.JAVA_HOME = "${jdkInstallation}"
                    env.PATH = "${jdkInstallation}/bin:${env.PATH}"
                }

                // Install and configure Gradle using the 'tools' step
                script {
                    def gradleInstallation = tool name: "${env.GRADLE_VERSION}", type: 'gradle'
                    env.PATH = "${gradleInstallation}/bin:${env.PATH}"
                }

                // Verify JDK and Gradle installations
                sh 'java -version'
                sh 'gradle -v'
                
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