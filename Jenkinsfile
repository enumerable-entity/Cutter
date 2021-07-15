pipeline{
    agent {
        label 'master'
    }
    stages{
        stage("Build&Packaging"){
            steps {
                sh 'mvn package -Dmaven.test.skip=true'
                sh 'cd target/'
                sh 'ls -la'
            }
        }
    }



}
