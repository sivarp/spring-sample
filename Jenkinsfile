node {
	
	checkout scm

	stage('Build') {
		docker.image('maven:3-alpine').inside {
			sh 'mvn -B build'
		}
	}

	stage 'Test'
	stage 'Deploy'
}