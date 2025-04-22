pipeline {
    agent any 
    stages{
        stage('code-pull'){
            step{
                git branch: 'dev', url: 'https://github.com/mayurmwagh/Project-frontend.git'
            }
        }
        stage('code-build'){
            step{
                sh '''
                    npm build
                    ng build
                '''
            }
        }
        stage('code-deploy'){
            step{
                sh '''
                    aws s3 cp --recursive dist/angular-frontend s3://cbz-frontend-project-bux123-king/
                '''
                
            }
        }
    }
}