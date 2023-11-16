pipeline {
    agent any

    environment {
        // Define the JDK tool name configured in Jenkins
        JDK_TOOL = 'JDK 19'
 }

    stages {
        stage('Build'){
            steps {
                echo 'Building Commission Project'
                sh './gradlew build'
            }
        }
        stage('Test') {
            steps {
                script {
                        def jdkInstallation = tool name: JDK_TOOL, type: 'jdk'
                        env.JAVA_HOME = "${jdkInstallation}"
                        env.PATH = "${jdkInstallation}/bin:${env.PATH}"
                        sh 'java -version'
                        sh 'javac -version'
                        }
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


// pipeline {
//     agent any

    
//     stages {
//         stage('Checkout') {
//             steps {
//                 // Check out your source code
//                 checkout scm
//             }
//         }

//         stage('Build') {
//             steps {
//                 // Install and configure the JDK using the 'tools' step
                

//                 // Your build steps go here
//                 // ...
//             }
//         }
//     }
// }