pipeline {
    agent any 
    stages{
        stage('code-pull'){
            steps {
                git branch: 'dev', url: 'https://github.com/mayurmwagh/Project-frontend.git'
            }
        }
        stage('code-build'){
            steps {
                sh '''
                    npm install
                    ng build
                '''
            }
        }
        stage('code-deploy'){
            steps {
                sh '''
                    aws s3 cp --recursive dist/angular-frontend s3://cbz-frontend-project-bux123-king/
                '''
                
            }
        }
    }
}