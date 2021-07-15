pipeline{
    agent {
        label 'master'
    }
    stages{
        stage("Build&Packaging"){
            steps {
                sh 'mvn package'
                cd 'target'
                ls '-la'
            }
        }
    }



}
