// pipeline {
//     agent any

//     tools {
//         jdk 'JDK 19'
//         gradle 'Gradle 8.4'
//     }
//     stages {
//         stage('Build'){
//             steps {
//                 echo 'Building Commission Project'
//                 sh './gradlew build'
//             }
//         }
//         stage('Test') {
//             steps {
//                 echo 'Testing...'
//                 sh './gradlew test'
//             }
//             post {
//                 always {
//                     junit "build/test-results/test/**/*.xml"
//                 }
//             }
//         }
//     }
// }


pipeline {
    agent any

    environment {
        // Define the JDK tool name configured in Jenkins
        JDK_TOOL = 'JDK 19'
    }

    stages {
        stage('Checkout') {
            steps {
                // Check out your source code
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Install and configure the JDK using the 'tools' step
                script {
                    def jdkInstallation = tool name: JDK_TOOL, type: 'jdk'
                    env.JAVA_HOME = "${jdkInstallation}"
                    env.PATH = "${jdkInstallation}/bin:${env.PATH}"
                    sh 'java -version'
                    sh 'javac -version'
                }

                // Your build steps go here
                // ...
            }
        }
    }
}